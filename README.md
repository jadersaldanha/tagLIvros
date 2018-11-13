# tagLivros

Olá!

Bem-vindo(a) a suíte de regressão automatizada em java utilizando Selenium WebDriver do portal TagLivros.
Essa suite tem a cobertura do fluxo de checkout.

A Url é a seguinte: http://52.54.253.46/associe-se/escolha-sua-caixinha

Esse projeto de automação foi idealizado com o foco em diversas possibilidades para casos de teste. Contempla a geração de relatórios de evidência de interação e preenchimento de dados com elementos da interface.

Organiza-se da seguinte forma:
- tagLivros
	- /src/main/java
		- appObjects
		- tasks
		- testCases
		- testSuite
		- verificationPoints
	- /src/main/resources
		- datapools
		- tagLivros
		- config.properties
	- Reports
		- screenshots
		
Onde: appObjects representa o pacote com as classes que identificam elementos da interface web do portal. tasks: tarefas que atuam nos elementos da interface identificados. testCases pacote que define as classes principais dos casos de teste automatizados. testSuite conjunto que chama as classes de caso de teste que desejar. verificaitonPoints onde estão as classes para validação de dados e/ou elementos de interface, etc. Na pasta datapools estão os arquivos necessários para a utilização da massa de dados para testes automatizados, é possível adicionar quantas linhas e dados quanto forem necessário. Para isso, basta escrever os dados de usuário em cada linha utilizando o separador ";". tagLivros estão as classes de suporte para o projeto. config.propeties armazena dados de ambiente, seja de homologação ou produção, etc. Na pasta reports serão armazenados screenshots e relatorios de evidência. O arquivo "AssinaturaClubeLivrosRegressionTestSuite.jar" é o executável dos casos de teste.  

Para executar o projeto é muito fácil \o/ basta seguir os passos:
- Fazer o download do projeto tagLivros;
- Na basta do projeto tagLivros clicar duas vezes no arquivo "AssinaturaClubeLivrosRegressionTestSuite.jar";
- Aguarde a execução dos testes \o/;
- Verifique a execução dos testes nas pastas "reports" e "screenshots".