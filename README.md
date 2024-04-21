<h1 align="center"> /In Memory DB\ </h1>

## Возможности
- Чтение всех записей
- Найти запись по любому из ее полей (O(1) в среднем)
- Создать новую запись
- Редактировать запись
- Удалить запись

## Методы
Все методы начинаются с localhost:8080/api/v1/

| URL | Метод | Назначение |
| --- | --- | --- |
| accounts | GET | Список всех записей |
| accounts/find-by-account/{account} | GET | Найти по номеру аккаунта |
| accounts/find-by-name/{name} | GET | Найти по имени |
| accounts/find-by-value/{value} | GET | Найти по значению |
| accounts/add | POST | Создание новой записи |
| accounts/update | UPDATE | Обновить запись |
| accounts/delete/{account} | DELETE | Отобразить конкретную запись по ID |

## Прогресс выполнения задания
1. Предоставлена возможность добавлять новые записи
2. Предоставлена возможность удалять более не нужные записи
3. Предоставлена возможность изменять запись
4. Предоставлена возможность получать полный набор записи по любому из полей с одинаковой алгоритмической сложностью (не медленнее log(n));
5. Выбран наиболее экономный способ хранения данных в памяти учитывая возможную многопоточность
6. Выбор структур данных и алгоритмов обоснован в WORD-файле
