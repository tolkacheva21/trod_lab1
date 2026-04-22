# User Service (Spring Boot + Docker + CI/CD)

REST API сервис для управления пользователями с поддержкой Docker и CI/CD pipeline.

---

# 📦 API

## 🔹 Получить всех пользователей

```
GET /api/users
```

## 🔹 Получить пользователя по ID

```
GET /api/users/{id}
```

## 🔹 Создать пользователя

```
POST /api/users
```

Пример body:

```json
{
  "name": "John",
  "email": "john@example.com",
  "password": "1234"
}
```

## 🔹 Обновить пользователя

```
PUT /api/users/{id}
```

## 🔹 Удалить пользователя

```
DELETE /api/users/{id}
```

---

# ⚙️ Запуск проекта

## 🔹 Через Docker Compose

```bash
docker-compose up --build
```

Приложение будет доступно:

```
http://localhost:8080
```

---

# 🧪 Тестирование

```bash
mvn clean test
```

---

# 📊 Coverage (JaCoCo)

После запуска тестов отчёт доступен:

```
target/site/jacoco/index.html
```

Требования:

* Coverage ≥ 50%
* При снижении — pipeline падает

---

# 🧹 Линтер (Checkstyle)

```bash
mvn checkstyle:check
```

Если найдены ошибки — сборка завершится с ошибкой.

---

# ⚙️ CI/CD Pipeline (GitHub Actions)

Pipeline автоматически запускается при:

* Pull Request
* Push в ветку `master`

## Этапы:

1. **Build** — сборка проекта
2. **Lint** — проверка Checkstyle
3. **Test** — тесты + coverage
4. **Docker-build** — сборка образа
5. **Docker-push** - push образа на Docker Hub
