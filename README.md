# Servidor HTTP em Java

Este projeto implementa um servidor HTTP simples em Java utilizando a classe `HttpServer` da biblioteca `com.sun.net.httpserver`. Ele processa requisições no endpoint `/test` e utiliza um manipulador personalizado para responder a essas requisições.

---

## 📋 Funcionalidades

- 🚀 Inicializa um servidor HTTP escutando na porta **8001**.
- 🌐 Endpoint `/test` para responder aos pedidos HTTP.
- ✨ Suporte a múltiplas requisições simultâneas utilizando um **Thread Pool** de 10 threads.
- 📜 Mensagem no console indicando o status do servidor: `Server started on port 8001`.

---

## 🛠️ Tecnologias Utilizadas

- **Java**: Linguagem de programação principal.
- **HttpServer**: Para a implementação do servidor HTTP simples.
- **ThreadPoolExecutor**: Para o processamento simultâneo de requisições.

---

## ⚙️ Como Executar

1. Certifique-se de ter o **Java 8+** instalado no seu ambiente.

2. Clone este repositório:

   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
   cd seu-repositorio
   ```

3. Compile e inicie a aplicação:

   ```bash
   javac -d bin src/**/*.java
   java -cp bin Application
   ```

4. O servidor será inicializado e estará acessível em [http://localhost:8001/test](http://localhost:8001/test).

---

## 📂 Estrutura do Projeto

```plaintext
src/
├── Application.java           # Classe principal que inicializa o servidor
└── domain/
    └── MyHttpHandler.java     # Manipulador de requisições HTTP
```

---

## 🚧 Melhorias Futuras

- Suporte a endpoints adicionais.
- Implementar respostas em **JSON** para as requisições HTTP.
- Adicionar suporte a configuração dinâmica de porta e número de threads.

---
