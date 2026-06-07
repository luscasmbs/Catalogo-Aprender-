# Checklist de Testes - Catálogo Aprender+

Este checklist registra a validação visual feita a partir do vídeo `evidencias/video-demo.mp4` e dos prints documentados em `EVIDENCIAS.md`.

Legenda de status:

- **Concluído:** requisito comprovado visualmente no vídeo/print.
- **Parcial:** requisito aparece parcialmente, mas ainda precisa de confirmação manual ou automatizada.
- **Não evidenciado no vídeo:** o requisito pode existir no app, mas não foi comprovado pela gravação analisada.

## 1. Inicialização e tela principal

| Item testado | Evidência | Status | Observação |
| --- | --- | --- | --- |
| App abre sem crash | `evidencias/prints/01_catalogo.png` | Concluído | O app aparece aberto e renderiza a tela principal. |
| Tela inicial exibe `Catálogo Aprender+` | `evidencias/prints/01_catalogo.png` | Concluído | Título visível no cabeçalho. |
| Tela inicial exibe `Explore cursos técnicos e profissionalizantes.` | `evidencias/prints/01_catalogo.png` | Concluído | Texto de apoio visível abaixo do título. |
| Campo de busca exibe `Busca` | `evidencias/prints/01_catalogo.png` | Concluído | Placeholder visível. |
| Lista inicial não fica em branco | `evidencias/prints/02_lista_cards_quantidade.png` | Concluído | Lista com cards visível. |

## 2. Lista, cards e contador

| Item testado | Evidência | Status | Observação |
| --- | --- | --- | --- |
| Cursos aparecem em cards | `evidencias/prints/02_lista_cards_quantidade.png` | Concluído | Os cursos são exibidos em cards. |
| Cards exibem nome breve e nome completo | `evidencias/prints/02_lista_cards_quantidade.png` | Concluído | Exemplo visível: `ADS` e nome completo do curso. |
| Cards exibem categoria, nível, status, carga horária e progresso | `evidencias/prints/02_lista_cards_quantidade.png` | Concluído | Informações aparecem nos cards. |
| Contador `Cursos exibidos: X` aparece | `evidencias/prints/02_lista_cards_quantidade.png` | Concluído | Contador aparece como `Cursos exibidos: 13`. |
| Rolagem/lista longa | `evidencias/prints/02_lista_cards_quantidade.png` | Parcial | A lista excede a tela; a rolagem deve ser confirmada manualmente. |

## 3. Busca, filtro e estado vazio

| Item testado | Evidência | Status | Observação |
| --- | --- | --- | --- |
| Busca por nome ou nome breve funciona | `evidencias/prints/03_busca_resultado.png` | Concluído | Busca por `ADS` retorna o curso correspondente. |
| Busca por categoria funciona | Sem print específico | Não evidenciado no vídeo | A gravação não mostra busca textual por categoria. |
| Filtro por categoria atualiza a lista | `evidencias/prints/04_filtro_ativo.png` | Concluído | Filtro `Dados` reduz a lista para 2 cursos. |
| Filtro ativo fica visualmente identificado | `evidencias/prints/04_filtro_ativo.png` | Concluído | Chip `Dados` aparece selecionado. |
| Busca e filtro funcionam juntos | Sem print específico | Não evidenciado no vídeo | Busca e filtro aparecem em momentos separados. |
| Busca inexistente exibe `Nenhum curso encontrado` | Sem print específico | Não evidenciado no vídeo | Não foi encontrado print do estado vazio. |
| Estado vazio exibe `Ajuste a busca ou altere o filtro selecionado.` | Sem print específico | Não evidenciado no vídeo | Não foi encontrado print do estado vazio. |

## 4. Seleção e navegação

| Item testado | Evidência | Status | Observação |
| --- | --- | --- | --- |
| Card é clicável | `evidencias/prints/05_card_selecionado.png` | Parcial | O card selecionado aparece visualmente destacado; o clique deve ser validado pela sequência do vídeo ou por teste manual. |
| Card selecionado possui destaque visual | `evidencias/prints/05_card_selecionado.png` | Concluído | O card `Design Ux e UI` aparece com destaque escuro. |
| Clique abre tela de detalhe | `evidencias/prints/06_detalhe.png` | Concluído | A tela de detalhe aparece na gravação. |
| Navegação usa detalhe do curso | `evidencias/prints/06_detalhe.png` | Parcial | A tela de detalhe aparece com dados de curso; a rota deve ser confirmada por inspeção de código/teste. |

## 5. Tela de detalhe

| Item testado | Evidência | Status | Observação |
| --- | --- | --- | --- |
| Tela exibe `Detalhe do curso` | `evidencias/prints/06_detalhe.png` | Concluído | Título visível no cabeçalho. |
| Tela exibe `Este curso faz parte da trilha Aprender+.` | `evidencias/prints/06_detalhe.png` | Concluído | Texto obrigatório visível no cabeçalho. |
| Detalhe exibe nome completo e nome breve | `evidencias/prints/06_detalhe.png` | Concluído | Exibe o curso e `ADS`. |
| Detalhe exibe categoria, nível, carga horária e status | `evidencias/prints/06_detalhe.png` | Concluído | Dados visíveis no card de detalhe. |
| Detalhe exibe progresso e descrição completa | `evidencias/prints/06_detalhe.png` | Concluído | Progresso e descrição aparecem no print. |
| Botão `Voltar` está presente | `evidencias/prints/06_detalhe.png` | Concluído | Botão visível no final da tela. |
| Botão `Voltar` retorna ao catálogo | Sem print específico | Parcial | O botão aparece; a ação precisa de validação manual. |
| Curso inexistente exibe `Curso não encontrado` | Sem print específico | Não evidenciado no vídeo | A gravação não mostra esse cenário. |

## 6. Evidência complementar

| Item testado | Evidência | Status | Observação |
| --- | --- | --- | --- |
| Tela de cadastro/preview foi executada | `evidencias/prints/07_cadastro_preview.png` | Concluído | Evidência complementar fora dos requisitos principais do catálogo. |

## 7. Pendências de evidência visual

Itens que ainda precisam de print, teste manual ou teste automatizado:

- Busca textual por categoria.
- Busca inexistente com `Nenhum curso encontrado`.
- Mensagem complementar `Ajuste a busca ou altere o filtro selecionado.`.
- Busca e filtro funcionando juntos no mesmo fluxo.
- Retorno efetivo do botão `Voltar`.
- Tratamento de curso inexistente com `Curso não encontrado`.
