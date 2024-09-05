package com.example.modsentesttask.web.mapper;

import com.example.modsentesttask.domain.book.Book;
import com.example.modsentesttask.domain.book.BookLoan;
import com.example.modsentesttask.domain.user.User;
import com.example.modsentesttask.service.BookService;
import com.example.modsentesttask.service.UserService;
import com.example.modsentesttask.web.dto.request.BookLoanRequestDto;
import com.example.modsentesttask.web.dto.response.BookLoanResponseDto;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookLoanMapper
        extends Mappable<BookLoan, BookLoanRequestDto, BookLoanResponseDto> {

    @Mapping(source = "bookId", target = "book", qualifiedByName = "mapBookIdToBook")
    @Mapping(source = "userId", target = "user", qualifiedByName = "mapUserIdToUser")
    BookLoan toEntity(
            BookLoanRequestDto dto,
            @Context BookService bookService,
            @Context UserService userService
    );

    @Named("mapBookIdToBook")
    default Book mapBookIdToBook(
            Long bookId,
            @Context BookService bookService
    ) {
        return bookService.getById(bookId);
    }

    @Named("mapUserIdToUser")
    default User mapUserIdToUser(
            Long userId,
            @Context UserService userService
    ) {
        return userService.getById(userId);
    }

}
