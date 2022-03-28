<h1 align="center">  CONVERSOR DE TXT PARA JSON </h1>
<h3 align="center"> Criacação de um sistema onde recebe arquivo.txt em um padrão e retorna os dados em formato Json.</h3>

<p align="center">
<img src="https://byspel.com/wp-content/uploads/2017/06/JSON-Logo.png" width="20%" height="20%"/>
</p>

<p>
<img src="http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge" width="18%" height="18%"/>
<img src="https://img.shields.io/github/languages/top/Mateusads/Conversor-de-TXT-para-JSON"/> 
<img src="https://github.com/Mateusads/Conversor-de-TXT-para-JSON/actions/workflows/maven.yml/badge.svg"/> 
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

Os id's que não tiverem todos os campos são preenchidos com 0 a esquerda e os nomes com espaço como exemplo. 

```
'0000000041                           Dr. Dexter Rolfson00000004470000000003     1563.4720210630'
```

## CI

Feito teste de Unidade com Junit para ao fazer o a Integração Continua onde ao rodar a pipeline no GitHub todos os testes devem passar para 
que não tenha problema na integração.

## CD 
Usando o Github Actions feito um script yml para fazer o deploy para o servidor, antes rodando os testes e 
tasks para garantir que tudo está correto.

# Rodando o projeto
 

Faça clone do projeto em sua maquina (copie o https e no seu terminal digite git clone <cole o link>)
  
Com o repositório em sua maquina, entre na pasta Conversor-de-TXT-para-JSON e digite "mvn clean install"
  
Agora abra o terminal e digite "Java -jar json-converter-1.0.jar <caminho do seu documento no padrão> (OBS: Caso não passe nenhum documento por parâmetro o documento de exemplo será exibido no formato Json)
  
