# *SAEP-Parecer-Pdf*
##### Modulo de relatorios de parecer para pdf do projeto SAEP (https://github.com/kyriosdata/saep), modulos de relatorios de parecer com base em JSON. Sistema sob licença Creative Commons Attribution 4.0 International License https://creativecommons.org/licenses/by/4.0/
-----------------------------------------------------------------------------

##### Para ultilizar esta API basta clonar o projeto e gerar o jar do mesmo, apos isso adcione o memo ao Classpath do seu projeto.
-----------------------------------------------------------------------------

# *API br.com.relatorio.pdfjson.jrxml.JsonPdfParecer / public byte[] gerarRelatorio(String json)*
##### Ao passar o JSON para o metodo o mesmo devolve um byte[] de um arquivo pdf, que pode ser manipulado pelo cliente da API conforme a necessidade. 
```json
{
	"instituto": "Instituto de Informatica - INF",
	"numProcesso": "123456",
	"sexo": true,
	"nomeProfessor": "Gabriel Barbosa de Oliveira",
	"letraClasse": "A",
	"numNivel": "10",
	"listaPontuacao": [{
		"numero": "1",
		"descricao": "DESCRICAO 2",
		"pontuacao": "PONTUACAO 2"
	}],
	"textoRodape": "TEXTO DO RODAPE",
	"cidade": "Goiania",
	"estado": "Goias",
	"dia": "04",
	"mes": "10",
	"ano": "1996",
	"membroCad1": "NOME DO MEMBRO DA CAD1",
	"membroCad2": "NOME DO MEMBRO DA CAD2",
	"presidenteCad": "NOME DO PRESIDENTE DA CAD"
}
```

##### Nenhum dos campos informados pode ser nulo, todas as informacoes requeridas no JSON sao fundamentais para API a falta de qualquer um deles resulta em uma java.lang.NullPointerException. 
##### No array de objetos listaPontuacao, devera ser passado no maximo 50 itens caso exceda este valor a API lancara uma java.lang.ArrayIndexOutOfBoundsException, veja caso de teste JsonPdfParecerTest4.
```json
	"listaPontuacao": [{
		"numero": "1",
		"descricao": "DESCRICAO 2",
		"pontuacao": "PONTUACAO 2"
	}]
  ```
##### Na variavel boolean devera ser passado true para Masculino e false para Feminio, veja casos de teste JsonPdfParecerTest2 & JsonPdfParecerTest3: 
  ```json
  "sexo": true
  ```
