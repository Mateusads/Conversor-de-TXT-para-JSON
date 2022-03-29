<h1 align="center">  CONVERSOR DE TXT PARA JSON </h1>

<p align="center">
<img src="http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge" width="18%" height="18%"/>
<img src="https://img.shields.io/github/languages/top/Mateusads/Conversor-de-TXT-para-JSON"/> 
<img src="https://github.com/Mateusads/Conversor-de-TXT-para-JSON/actions/workflows/maven.yml/badge.svg"/> 
 </p>
 
<h3 align="center"> Criacação de um sistema onde recebe arquivo.txt em um padrão e retorna os dados em formato Json.</h3>

<p align="center">
<img src="https://byspel.com/wp-content/uploads/2017/06/JSON-Logo.png" width="20%" height="20%"/>
</p>




O programa consistem em receber um Arquivo 'txt' por args[] (parâmetro), recebendo o caminho (path do arquivo)

Exemplo: "./src/main/resources/fileData.txt"
Esse arquivo deve seguir um padrão de seus campos, e o retorno será um Json associando a um usuário para várias ordens e uma ordem para vários produtos.

O padrão do arquivo é divido no tamanho máximo de cada tabela 

```
UserID = 10   -> 0000000041
UserName = 45 -> '                           Dr. Dexter Rolfson'
OrderId = 10 -> 0000000447
ProductId = 10 -> 0000000003
ProducValue = 12 -> '     1563.47'
OrderDate = 8  - 20210630 ( formato: yyyymmdd )
```

Os id's que não tiverem todos os campos são preenchidos com 0 a esquerda e os restante com espaço como exemplo. 

```
'0000000069                             Dr. Tyree Rogahn00000007430000000002      1401.620210317'
```
Somando um total de 95 caracteres (junto com os espaços).

Linhas que contém algum erro fora do padrão pode ser alteradas, ou removidas, para que não afete o programa e as outras linhas possam ser executadas com sucesso. (Datas inexistente ou padrão incorretos serão convertido para 1900-1-1)

## CI

Feito teste de Unidade com Junit para ao fazer o a Integração Continua onde ao rodar a pipeline no GitHub todos os testes devem passar para 
que não tenha problema na integração.

## CD (Em desenvolvimento)
Usando o Github Actions feito um script yml para fazer o deploy para o servidor, antes rodando os testes e 
tasks para garantir que tudo está correto.

## Requisitos.
Java 11 ou superior | Maven 3.6.3 ou superior | Git (instalado)

# Rodando o projeto

Faça clone do projeto em sua maquina (copie o https e no seu terminal digite git clone "cole o link")
  
Com o repositório em sua maquina, entre na pasta Conversor-de-TXT-para-JSON e digite "mvn clean install"
  
Agora dentro da pasta target que foi gerada, abra o terminal e digite "Java -jar json-converter-1.0.jar "caminho do seu documento no padrão" exemplo C:\Documents\arquivo.txt

(OBS: Caso não passe nenhum caminho por parâmetro o documento de exemplo será exibido no formato Json)
  
