###
<details>
<summary>Maven</summary>

```xml
<dependency>
    <groupId>com.github.gabriaum</groupId>
    <artifactId>actionbar-api</artifactId>
    <version>1.0.0</version>
</dependency>
```
</details>

<details>
<summary>Gradle</summary>

```groovy
repositories {
    maven {
        url = uri("https://jitpack.io")
    }
}

dependencies {
    compileOnly("com.github.gabriaum:inventory-framework-lib:1.0.0")
}
```
</details>

<details>
<summary>Gradle (kts)</summary>

```kts
repositories {
    maven(url = "https://jitpack.io")
}

dependencies {
    compileOnly("com.github.gabriaum:inventory-framework-lib:1.0.0")
}
```
</details>

<h3 align="center">MAIN CLASS</h3>
<p align="center">This only applies to Lib implementations.</p>

```java
public class YourMain extends JavaPlugin {

    private InventoryProctor inventoryProctor;

    @Override
    public void onLoad() {
        inventoryProctor = new InventoryProctor(this);
    }

    @Override
    public void onEnable() {
        inventoryProctor.registry();
    }
}
```