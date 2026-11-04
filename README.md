# PDC-Studio
aplicativo Android para organização de estudos, desenvolvido com Kotlin, WebView, HTML, CSS e JavaScript.
# PDC Studio 📚

**Central de Estudos & Materiais**

O PDC Studio é um aplicativo Android desenvolvido para organizar estudos, disciplinas, temas e materiais acadêmicos em um único ambiente.

O projeto utiliza tecnologias web integradas a um aplicativo Android nativo, proporcionando uma experiência independente do navegador.

## 🚀 Funcionalidades

- Organização de temas e categorias de estudo.
- Gerenciamento de materiais acadêmicos.
- Importação e organização de arquivos PDF e imagens.
- Anotações e conteúdos de estudo.
- Pesquisa global de materiais.
- Interface responsiva.
- Tema claro e escuro.
- Armazenamento local com IndexedDB.
- Exportação e importação de backups em JSON.
- Seleção de arquivos pelo sistema Android.

## 🛠️ Tecnologias utilizadas

### Aplicativo Android
- Android Studio
- Kotlin
- Jetpack Compose
- Android WebView
- Gradle Kotlin DSL

### Interface e funcionalidades
- HTML5
- CSS3
- JavaScript
- Tailwind CSS
- IndexedDB
- localStorage
- Phosphor Icons

## 🏗️ Arquitetura

O aplicativo utiliza uma arquitetura híbrida:

1. A aplicação Android é responsável pela execução e integração com o sistema operacional.
2. A MainActivity.kt inicializa a WebView.
3. A WebView carrega o arquivo `index.html` armazenado nos recursos internos do aplicativo.
4. O JavaScript gerencia as funcionalidades da aplicação.
5. O IndexedDB armazena categorias e materiais localmente.

## 📂 Estrutura do projeto

```text
PDCStudio/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── assets/
│   │       │   └── index.html
│   │       ├── java/
│   │       │   └── com/example/pdcstudio/
│   │       │       ├── MainActivity.kt
│   │       │       └── ui/theme/
│   │       ├── res/
│   │       └── AndroidManifest.xml
│   └── build.gradle.kts
├── gradle/
├── build.gradle.kts
├── gradle.properties
├── gradlew
├── gradlew.bat
└── settings.gradle.kts
```

## ⚙️ Como executar

1. Instale o Android Studio.
2. Clone este repositório.
3. Abra o projeto no Android Studio.
4. Aguarde a sincronização do Gradle.
5. Execute o aplicativo em um dispositivo Android ou emulador.

## 📱 Requisitos técnicos

- Android mínimo: API 24 (Android 7.0).
- Kotlin.
- Android Studio compatível com as versões de Gradle e Android Gradle Plugin do projeto.
- Conexão com a internet para carregar recursos visuais externos utilizados pela interface.

## 💾 Armazenamento e backup

Os materiais e categorias são armazenados localmente utilizando IndexedDB.

As preferências de interface utilizam localStorage.

O aplicativo oferece exportação e importação de backups em JSON.

Os dados não são sincronizados automaticamente com servidores ou com outros dispositivos.

## 🔒 Privacidade

O armazenamento dos materiais é realizado localmente no dispositivo. A preservação dos dados depende também dos backups realizados pelo usuário.

## 📌 Versão

**Versão atual:** 1.0.0

**Status:** Aplicativo funcional — documentação e publicação do código-fonte em andamento.

---

Desenvolvido como projeto de organização e produtividade acadêmica.
