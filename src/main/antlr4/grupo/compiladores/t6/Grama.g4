grammar Grama;

programa: 'algoritmo' 'Clientes' '(' lista_clientes ')' cmd*? 'fimAlgoritmo';

lista_clientes: cliente+;

cliente: TIPO '{' lista_atributos '}';

lista_atributos: atributo (',' atributo)*;

atributo: 'Nome:' STRING
        | 'ValorInvestido:' NUMERO
        | 'TempoInvestido:' NUMERO
        | 'LucroAlmejado:' NUMERO;

cmd: cmdPrevisao | cmdPassado | cmdVisualizar | cmdAlertaRisco;

cmdPrevisao: 'Previsao' '(' tipoInvestimento ',' '{' NUMERO (',' NUMERO)* '}' ')' |
             'Previsao' '(' nome ',' tipoInvestimento ')';

cmdPassado: 'Passado' '(' nome ',' tipoInvestimento ',' periodicidade ')';

cmdAlertaRisco: 'Alerta' '(' tipoInvestimento ')';

cmdVisualizar: 'Mostrar' '()';

nome: STRING;

tipoInvestimento: Fixa | Variavel;

Fixa: 'TESOURO';

Variavel: 'AAPL' | 'MSFT' | 'GOOGL' | 'JPM' | 'TSLA' | 'NVDA' | 'BTC-USD'; 

periodicidade: 'DIARIO' | 'MENSAL' | 'ANUAL';

// Tokens
STRING: '"' ('\\' . | ~('\\'|'"'))* '"';
TIPO:[a-zA-Z_][a-zA-Z_0-9]*;
NUMERO: [0-9]+('.'[0-9]+)?;
WS: [ \t\r\n]+ -> skip;

//Reconhece qualquer caractere que não foi reconhecido anteriormente, portanto, será tratado como erro
//no programa que utilzará essa gramática
ERRO : . ;

// Fragmento para tratar escape sequences como \n, \t, etc.
fragment ESC_SEQ : '\\' . ;

// Comentários delimitados por colchetes: ignora tudo entre `[` e `]`, exceto novas linhas e o delimitador `]`.
COMMENT : '[' (ESC_SEQ | ~('\n' | ']'))* ']' -> skip;

// Comentários de uma linha: começa com `[` e termina com uma quebra de linha.
LINE_COMMENT : '[' ~('\n')* '\n' -> skip;
