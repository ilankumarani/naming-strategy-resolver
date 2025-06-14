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


___

## Self index to re-gain my Knowledge
<details>
  <summary>Click me</summary>

### Two ways to resolve Spel expression 

#### Option 1. Making sure StringValueResolverProvider is loaded before CustomPhysicalNamingStrategy
```java
@DependsOn(StringValueResolverProvider.BEAN_NAME)
@Configuration
public class CustomPhysicalNamingStrategy extends PhysicalNamingStrategyStandardImpl {
    
}
```
#### Option 2. ApplicationPreparedEvent is loaded after ApplicationContext and we get the resolver from ApplicationContext
```java
public class HibernatePropertiesRegister implements ApplicationListener<ApplicationPreparedEvent> {

    /**
     * Spring will use it for creating the bean in IOC container
     */
    public HibernatePropertiesRegister() {

    }

    public void onApplicationEvent(ApplicationPreparedEvent event) {
        log.info("CustomPhysicalNamingStrategy is set for Hibernate Environment");

        ApplicationContext applicationContext = event.getApplicationContext();
        ConfigurableEnvironment environment = (ConfigurableEnvironment) applicationContext.getEnvironment();

        ConfigurableListableBeanFactory configurableListableBeanFactory = ((AnnotationConfigApplicationContext) applicationContext).getBeanFactory();
        CarrierSpelResolverProvider.setConfigurableListableBeanFactory(configurableListableBeanFactory);

    }
}
```

</details>