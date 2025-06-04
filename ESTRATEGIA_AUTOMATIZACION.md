# 📌 Estrategia de Automatización

## 🧠 Patrones Utilizados
1. **Page Object Model (POM)**
    - Clases separadas para cada página (`LoginPage.java`, `ProductsPage.java`)
    - Métodos que representan acciones del usuario

2. **Behavior-Driven Development (BDD)**
    - Feature files en Gherkin (`login.feature`, `checkout.feature`)
    - Step definitions en Java

3. **Singleton para manejo de browser**
    - `BrowserFactory` centraliza la creación del navegador

## 🧪 Tipos de Pruebas Implementadas
- Login con credenciales válidas/inválidas
- Flujo completo de compra
- Manejo de carrito de compras

## 🔧 Configuración Técnica
```java
// Ejemplo de implementación POM
public class LoginPage {
    private final Page page;
    private final String usernameInput = "#user-name";
    
    public void login(String user, String pass) {
        page.fill(usernameInput, user);
        // ...
    }
}
```

## 📈 Cobertura de Pruebas
| Feature        | Scenarios |
|----------------|-----------|
| Login          | 3         |
| Cart           | 2         |
| Checkout       | 1         |