# 🚀 SauceDemo Automation Suite

Automatización de pruebas para [Sauce Demo](https://www.saucedemo.com/) usando:
- **Playwright** (Browser automation)
- **Cucumber** (BDD)
- **Java 21**
- **Maven** (Dependency management)

## 📋 Prerrequisitos
- Java 21 JDK
- Maven 3.9.9
- Git (opcional)

## 🛠 Configuración
```bash
git clone https://github.com/mamannucc81/sauce-demo-automation.git
cd sauce-demo-automation
mvn clean install
```

## ▶️ Ejecución
```bash
# Ejecutar todos los tests (modo headless)
mvn test

# Ejecutar con Chrome visible
mvn test -Dheadless=false -Dbrowser=chromium

# Ejecutar un feature específico
mvn test -Dcucumber.features="src/test/resources/features/login.feature"
```

## 📊 Estructura del proyecto
```
sauce-demo-automation/
├── src/
│   ├── main/java/com/saucedemo/pages/       # Page Objects
│   ├── test/java/com/saucedemo/runners/     # Test Runner
│   └── test/resources/features/             # Feature files
├── pom.xml
└── README.md
```

## 🛠 Troubleshooting
Si encuentras problemas:
- Verifica que tienes Java 21
- Ejecuta `mvn clean install -U` para actualizar dependencias