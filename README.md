К созданному [в прошлой лабораторной](https://github.com/NumeroQuadro/is-tech-y26-cats-tracking/tree/master) сервису добавляется **Spring**.
# Условие лабораторной
Сервис должен предоставлять **HTTP интерфейс** (REST API) для получения информации о конкретных котиках и владельцах и для получения фильтрованной информации (например, получить всех рыжих котиков)

**Внимание**: недопустимо отдавать через HTTP интерфейс сущности JPA. **Рекомендуется создать отдельные оберточные классы**.

Сервисы и DAO должны превратиться в **Spring Bean’ы** с использованием **Dependency Injection** (Autowired). DAO при этом наследуют **JpaRepository** и имеет **шаблонные Spring Data JPA методы**.

При сдаче лабораторной нужно будет показать работоспособность endpoint’ов через HTTP запросы (рекомендуется **Postman**).
