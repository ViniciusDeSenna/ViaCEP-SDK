# ViaCEP-SDK
SDK para facilitar o uso do ViaCEP, um webservice gratuito de alto desempenho para consulta de Código de Endereçamento Postal (CEP) do Brasil. 

![ViaCEP-SDK](https://github.com/user-attachments/assets/c3e07eb8-a914-45af-a0a0-806f318fd261)

## Como instalar

### Configurações
Primeiro você precisa ter um `settings.xml` com o conteudo abaixo no diretorio `~/.m2/settings.xml`. \
🔒 `USERNAME`: nome de usuário do GitHub. \
🔒 `GITHUB_TOKEN`: token pessoal de acesso (Personal Access Token com permissões de `read:packages`).
```xml
<servers>
    <server>
        <id>github</id>
        <username>USERNAME</username>
        <password>GITHUB_TOKEN</password>
    </server>
</servers>
```

### Repositórios
No seu arquivo `pom.xml` adicione os seguintes conteudos: \
🆚 `LAST_VERSION`: 🔗 [Consulte a ultima versão](https://github.com/ViniciusDeSenna/ViaCEP-SDK/packages/2496406)
```xml
<repositories>
    <repository>
        <id>github</id>
        <url>https://maven.pkg.github.com/ViniciusDeSenna/ViaCEP-SDK</url>
    </repository>
</repositories>

<dependencies>
  ...
  <dependency>
      <groupId>com.senna</groupId>
      <artifactId>viacep-sdk</artifactId>
      <version>LAST_VERSION</version>
  </dependency>
</dependencies>
```

## Como usar
```java
ViaCepClient viaCepClient = new ViaCepClient();
ViaCepResponse response = viaCepClient.get("01001-000")
```
