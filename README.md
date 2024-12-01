### To read table name from properties
```java
@Table(name = "${tableName.employee:EMPLOYEE}"
        , schema = "${schemaName.employee:EMPLOYEE_SCHEMA}"
        , catalog = "${catalogName.employee:EMPLOYEE_DB}"
)
public class Employee {
    // entity fields
}
```

```yaml
tableName:
  employee: EMPLOYEE_TABLE
```

### To read Schema name from properties
```java
@Table(name = "${tableName.employee:EMPLOYEE}"
        , schema = "${schemaName.employee:EMPLOYEE_SCHEMA}"
        , catalog = "${catalogName.employee:EMPLOYEE_DB}"
)
public class Employee {
    // entity fields
}
```

```yaml
schemaName:
  employee: EMP_SCHEMA
```

### To read Catalog name(DB name) from properties

```java
@Table(name = "${tableName.employee:EMPLOYEE}"
        , schema = "${schemaName.employee:EMPLOYEE_SCHEMA}"
        , catalog = "${catalogName.employee:EMPLOYEE_DB}"
)
public class Employee {
    // entity fields
}
```

```yaml
catalogName:
  employee: testDb
```

### To read Column name from properties

```java
@Column(name = "${column.employee.name:NAME}")
private String name;
```

```yaml
column:
  employee:
    name: FULL_NAME
```


### To disable this feature
```yaml
naming:
  physical-strategy:
    enabled: false
```