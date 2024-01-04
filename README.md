# Описание структуры проекта

## Взаимодействия с внешним API

Все **модели** (сущности), получаемые с сервера должны быть описаны.

Модели должны располагаться по следующему пути:

```bash
└───utils
    └───models
```

Пример описания модели:

```typescript
type Item = {
  id: number;
  title: string;
  description: string;
  firstPrice: number;
  user: User;
  category: string;
  mpLink: string;
  isActive: boolean;
  createdAt: string;
};

export default Item;
```

Взаимодействия с endpoint'ами должно быть структурированно следующим образом:

```bash
└───utils
    ├───api
    │   └───services
```

Важно соблюдать принцип единственной отвественности.

Схемы для валидации предлагаю хранить также в папке utils:

```bash
└───utils
    └───schemas
```