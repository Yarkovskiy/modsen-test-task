### Как запустить приложение
1. Создать новую базу данных в postgresql

2. Создать в корневом каталоге проекта файл `.env` со следующими полями:

`HOST=`localhost

`POSTGRES_USERNAME=`имя_пользователя_в_postgresql

`POSTGRES_PASSWORD=`пароль_в_postgresql

`POSTGRES_DATABASE=`имя_созданной_базы_данных

`JWT_SECRET=`QW5kIHN1ZGRlbmx5IEkgc2F3IHRoZSBsaWdodCBzaGluZSwgYW5kIGEgdm9pY2Ugc2FpZDogJ1lvdSBhcmUgb24gdGhlIHJpZ2h0IHBhdGg

4. Запустить приложение

5. В браузере перейти по пути http://localhost:8080/swagger-ui/index.html

---

Изначально в БД есть два пользователя, один из которых администратор. Обычный пользователь может использовать не все конечные точки.

Данные для авторизации в формате `username:password`:

`admin@example.com:admin`

`user@example.com:user`
