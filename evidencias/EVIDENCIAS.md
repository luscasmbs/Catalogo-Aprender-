# Evidências de Execução - Catálogo Aprender+

## 1. Objetivo

Este arquivo registra evidências visuais do funcionamento do app Catálogo Aprender+. As imagens foram selecionadas para comprovar, de forma objetiva, telas, fluxos e requisitos previstos no briefing do projeto.

## 2. Origem das evidências

Os prints foram extraídos do vídeo:

`evidencias/video-demo.mp4`

Observação sobre a extração: `ffmpeg` não estava disponível no ambiente e a alternativa Python/OpenCV também não estava instalada. Os quadros foram extraídos por renderização local do vídeo com recursos nativos do Windows/PowerShell.

## 3. Prints e requisitos comprovados

### Tela inicial do catálogo

![Tela inicial do catálogo](evidencias/prints/01_catalogo.png)

**Requisitos/checklist relacionados:** RF01, testes de inicialização, textos obrigatórios da tela principal.

O print comprova que o app abre na tela de catálogo, exibindo o título `Catálogo Aprender+`, o texto `Explore cursos técnicos e profissionalizantes.`, o campo `Busca`, filtros e cards de cursos.

### Lista com cards e quantidade de cursos exibidos

![Lista com cards e quantidade](evidencias/prints/02_lista_cards_quantidade.png)

**Requisitos/checklist relacionados:** RF01, RF04, RF10, lista com cards, contador de cursos exibidos.

O print comprova a lista vertical de cursos em cards, contendo nome breve, nome completo, categoria, nível, status, carga horária e progresso. Também mostra o contador `Cursos exibidos: 13`.

### Busca com resultado

![Busca com resultado](evidencias/prints/03_busca_resultado.png)

**Requisitos/checklist relacionados:** RF02, busca por nome, busca por nome breve, atualização da lista filtrada.

O print mostra a busca por `ADS` retornando o curso correspondente e atualizando a quantidade exibida para `Cursos exibidos: 1`.

### Busca sem resultado e estado vazio

**Status:** Não evidenciado no vídeo.

**Requisitos/checklist relacionados:** RF09, busca inexistente, estado vazio.

Não foi localizado no vídeo um momento claro em que uma busca inexistente exibisse `Nenhum curso encontrado` e `Ajuste a busca ou altere o filtro selecionado.`. Portanto, este requisito deve ser validado por teste manual ou automatizado complementar.

### Filtro ativo

![Filtro ativo](evidencias/prints/04_filtro_ativo.png)

**Requisitos/checklist relacionados:** RF03, filtro por categoria, filtro ativo visualmente identificado.

O print comprova o filtro `Dados` ativo, com a lista reduzida para cursos dessa categoria e contador `Cursos exibidos: 2`.

### Busca e filtro funcionando juntos

**Status:** Não evidenciado no vídeo.

**Requisitos/checklist relacionados:** RF02, RF03, busca e filtro combinados.

O vídeo mostra busca com resultado e filtro ativo em momentos separados, mas não mostra claramente uma busca aplicada ao mesmo tempo que um filtro diferente de `Todos`. Este item precisa de validação complementar.

### Card selecionado/clicável

![Card selecionado](evidencias/prints/05_card_selecionado.png)

**Requisitos/checklist relacionados:** RF04, RF05, RF06, card clicável, seleção visual de item.

O print mostra o card `Design Ux e UI` com destaque visual em relação aos demais cards, indicando seleção. A sequência do vídeo também demonstra navegação para a tela de detalhe em outro momento.

### Tela de detalhe

![Tela de detalhe](evidencias/prints/06_detalhe.png)

**Requisitos/checklist relacionados:** RF06, RF07, fluxo lista-detalhe, rota com identificador do curso.

O print comprova a tela `Detalhe do curso`, exibindo o texto `Este curso faz parte da trilha Aprender+.`, dados completos do curso, progresso, descrição completa e botão `Voltar`.

### Detalhe exibindo dados do curso correto

![Detalhe com dados do curso](evidencias/prints/06_detalhe.png)

**Requisitos/checklist relacionados:** RF07, detalhe correspondente ao curso selecionado.

O print mostra o detalhe do curso `Curso Técnico em Análise e Desenvolvimento de Sistemas`, com nome breve `ADS`, categoria, nível, carga horária, status, progresso e descrição completa.

### Botão voltar

![Botão voltar](evidencias/prints/06_detalhe.png)

**Requisitos/checklist relacionados:** RF06, RF07, ação de voltar.

O print comprova a presença do botão `Voltar` na tela de detalhe. A imagem comprova a existência da ação; o funcionamento do retorno deve ser confirmado no teste manual.

### Tratamento "Curso não encontrado"

**Status:** Não evidenciado no vídeo.

**Requisitos/checklist relacionados:** RF08, tratamento de identificador inválido ou inexistente.

Não foi localizado no vídeo um momento mostrando a mensagem `Curso não encontrado`. Este requisito deve ser comprovado por teste manual, teste automatizado ou evidência adicional.

### Evidência complementar de cadastro e pré-visualização

![Cadastro com pré-visualização](evidencias/prints/07_cadastro_preview.png)

**Requisitos/checklist relacionados:** evidência complementar de execução e registro visual do app em uso.

O print mostra a tela de cadastro com pré-visualização do curso `ADS`. Esta evidência não substitui os requisitos principais do catálogo, mas reforça que o app foi executado e manipulado durante a demonstração.

## 4. Checklist de validação

| Item testado | Evidência | Status | Observação |
| --- | --- | --- | --- |
| App abre sem crash | `01_catalogo.png` | Concluído | O vídeo mostra o app aberto e renderizando a tela principal. |
| Tela exibe "Catálogo Aprender+" | `01_catalogo.png` | Concluído | Texto visível no cabeçalho. |
| Tela exibe "Explore cursos técnicos e profissionalizantes." | `01_catalogo.png` | Concluído | Texto visível abaixo do título. |
| Lista usa cards | `02_lista_cards_quantidade.png` | Concluído | Cursos aparecem em cards com informações resumidas. |
| Quantidade de cursos exibidos aparece | `02_lista_cards_quantidade.png` | Concluído | Contador visível como `Cursos exibidos: 13`. |
| Busca por nome funciona | `03_busca_resultado.png` | Concluído | Busca por `ADS` retorna o curso correspondente. |
| Busca por categoria funciona | `04_filtro_ativo.png` | Parcial | O vídeo comprova filtro por categoria; busca textual por categoria não aparece de forma isolada. |
| Busca inexistente exibe estado vazio | Sem print | Não evidenciado no vídeo | Não foi localizado print com `Nenhum curso encontrado`. |
| Filtro atualiza a lista | `04_filtro_ativo.png` | Concluído | Filtro `Dados` reduz a lista para 2 cursos. |
| Busca e filtro funcionam juntos | Sem print | Não evidenciado no vídeo | Busca e filtro aparecem em momentos separados. |
| Card é clicável | `05_card_selecionado.png`, `06_detalhe.png` | Parcial | Há destaque de seleção e detalhe no vídeo, mas o print isolado não registra o clique. |
| Clique abre detalhe | `06_detalhe.png` | Concluído | A tela de detalhe aparece na demonstração. |
| Detalhe corresponde ao curso clicado | `06_detalhe.png` | Parcial | O detalhe mostra dados completos de `ADS`; a relação exata com o clique deve ser validada pela sequência do vídeo. |
| Detalhe exibe "Este curso faz parte da trilha Aprender+." | `06_detalhe.png` | Concluído | Texto visível no cabeçalho da tela de detalhe. |
| Botão voltar funciona | `06_detalhe.png` | Parcial | O botão `Voltar` está visível; o retorno efetivo não foi isolado em print. |
| Curso inexistente é tratado | Sem print | Não evidenciado no vídeo | Não há evidência visual da tela `Curso não encontrado`. |

## 5. Limitações das evidências

O vídeo não apresentou evidência visual clara para todos os requisitos. Não foram comprovados visualmente: busca sem resultado, estado vazio com `Nenhum curso encontrado`, busca e filtro funcionando juntos no mesmo momento, funcionamento efetivo do botão voltar e tratamento `Curso não encontrado`.

Alguns quadros intermediários extraídos do vídeo mostravam teclado, transições ou telas parciais. Eles foram descartados da documentação final para evitar evidências ambíguas.

## 6. Observações técnicas

Este arquivo não substitui testes manuais ou automatizados. Ele serve como evidência visual da execução do aplicativo e deve ser usado junto com o checklist de testes, validações manuais e resultados de testes automatizados quando disponíveis.
