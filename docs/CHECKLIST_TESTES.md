# 📋 CHECKLIST_TESTES.md — Catálogo Aprender+

[cite_start]Este documento registra a execução sistemática dos testes manuais obrigatórios realizados no aplicativo **Catálogo Aprender+** (Semana 04 — Listas, estado e navegação em Compose). [cite_start]A estrutura unifica a agilidade das listas de tarefas nativas do Git (`- [ ]`) com o rigor de auditoria, metadados e rastreabilidade exigidos pelos critérios oficiais da WorldSkills.

**Competidor:** Competidor Ocupação 08 — PE
**Data da última atualização:** 05/06/2026
**Hash do Commit de Fechamento:** `[feat: finaliza ciclo de testes e documentação]`

---

## 1. Testes de Inicialização, Compilação e Ambiente
[cite_start]Mapeia a estabilidade básica do ecossistema e a integridade do ciclo de build[cite: 1694, 1695].

- [ ] **Item 1.1 — Sincronização do Motor Gradle**
  * [cite_start]**Cenário de Teste:** Importar o projeto no Android Studio e acionar `Sync Project with Gradle Files`[cite: 1694].
  * [cite_start]**Comportamento Esperado:** Sincronização concluída com sucesso, sem falhas de dependências ou incompatibilidade de plugins (Jetpack Compose, Material 3 e Navigation Compose)[cite: 1695].
  * **Resultado Real:** ( ) Passou  |  ( ) Falhou
  * **Commit Vinculado:** `[chore: ...]` | **Evidência:** `docs/evidencias/build_sync.png`

- [ ] **Item 1.2 — Compilação Limpa (Build Execution)**
  * **Cenário de Teste:** Executar `Build → Make Project` ou `./gradlew assembleDebug`.
  * **Comportamento Esperado:** Geração completa do APK final sem erros de compilação em código Kotlin ou na árvore de composables.
  * **Resultado Real:** ( ) Passou  |  ( ) Falhou
  * **Commit Vinculado:** `[build: ...]`

- [ ] **Item 1.3 — Estabilidade de Inicialização (Anti-Crash)**
  * [cite_start]**Cenário de Teste:** Lançar o aplicativo a partir do launcher do sistema operacional Android[cite: 1541].
  * [cite_start]**Comportamento Esperado:** A UI renderiza a tela de catálogo imediatamente[cite: 1667]. [cite_start]O app não sofre fechamento inesperado (*crash on startup*)[cite: 1541]. [cite_start]A lista de cursos é exibida sem exigir ação do usuário[cite: 1643].
  * **Resultado Real:** ( ) Passou  |  ( ) Falhou
  * **Commit Vinculado:** `[feat: ...]`

- [ ] **Item 1.4 — Arquitetura de Inicialização Limpa**
  * [cite_start]**Cenário de Teste:** Inspeção estática no arquivo `MainActivity.kt`.
  * [cite_start]**Comportamento Esperado:** A `MainActivity` invoca `setContent` apenas para acionar o tema e o composable de navegação principal (`NavHost`)[cite: 1725, 1766]. [cite_start]Lógica de UI, estados e filtros devem estar desacoplados da Activity[cite: 1612].
  * **Resultado Real:** ( ) Passou  |  ( ) Falhou
  * **Commit Vinculado:** `[arch: ...]`

---

## 2. Interface Visual e Textos Obrigatórios Estritos (Conformidade Rubrica)
[cite_start]Validação de conformidade textual e presença de componentes para auditoria estrita de UI[cite: 1647, 1684].

- [ ] **Item 2.1 — Título Principal da Tela de Catálogo**
  * [cite_start]**Comportamento Esperado:** Exibição exata e literal da string: `"Catálogo Aprender+"`[cite: 1684].
  * **Resultado Real:** ( ) Passou  |  ( ) Falhou
  * **Commit Vinculado:** `[ui: ...]`

- [ ] **Item 2.2 — Subtítulo Informativo da Tela de Catálogo**
  * [cite_start]**Comportamento Esperado:** Exibição exata e literal da string: `"Explore cursos técnicos e profissionalizantes."`[cite: 1663].
  * **Resultado Real:** ( ) Passou  |  ( ) Falhou
  * **Commit Vinculado:** `[ui: ...]`

- [ ] **Item 2.3 — Placeholder do Campo de Busca**
  * **Comportamento Esperado:** Exibição exata e literal da string de dica: `"Busca"`.
  * **Resultado Real:** ( ) Passou  |  ( ) Falhou
  * **Commit Vinculado:** `[feat: ...]`

- [ ] **Item 2.4 — Opção "Todos" na Área de Filtros**
  * [cite_start]**Comportamento Esperado:** Presença de opção de filtro rotulada exatamente como `"Todos"`, selecionada por padrão ao abrir o app[cite: 1214].
  * **Resultado Real:** ( ) Passou  |  ( ) Falhou
  * **Commit Vinculado:** `[feat: ...]`

- [ ] **Item 2.5 — Contador de Cursos Exibidos**
  * [cite_start]**Comportamento Esperado:** Presença do texto dinâmico no formato exato: `"Cursos exibidos: X"`, onde X representa o número de cursos visíveis[cite: 1213].
  * **Resultado Real:** ( ) Passou  |  ( ) Falhou
  * **Commit Vinculado:** `[feat: ...]`

- [ ] **Item 2.6 — Controles de Modo de Visualização (RF11)**
  * [cite_start]**Comportamento Esperado:** Presença de alternadores rotulados exatamente como `"Cards"` e `"Lista"`[cite: 1335]. [cite_start]O modo ativo deve ser visualmente identificável[cite: 1335].
  * **Resultado Real:** ( ) Passou  |  ( ) Falhou
  * **Commit Vinculado:** `[feat: ...]`

- [ ] **Item 2.7 — Título Obrigatório da Tela de Detalhe**
  * [cite_start]**Comportamento Esperado:** Exibição exata e literal da string: `"Detalhe do curso"` como título do header[cite: 1298].
  * **Resultado Real:** ( ) Passou  |  ( ) Falhou
  * **Commit Vinculado:** `[ui: ...]`

- [ ] **Item 2.8 — Texto Obrigatório da Trilha na Tela de Detalhe**
  * [cite_start]**Comportamento Esperado:** Exibição exata e literal da string: `"Este curso faz parte da trilha Aprender+."`[cite: 1461].
  * **Resultado Real:** ( ) Passou  |  ( ) Falhou
  * **Commit Vinculado:** `[ui: ...]`

- [ ] **Item 2.9 — Mensagem Obrigatória de Curso Não Encontrado**
  * [cite_start]**Cenário de Teste:** Forçar a navegação com um `cursoId` inválido (ex: id `-1` ou `9999`).
  * **Comportamento Esperado:** Exibição exata e literal da string: `"Curso não encontrado"`. [cite_start]O app não deve sofrer crash.
  * **Resultado Real:** ( ) Passou  |  ( ) Falhou
  * **Commit Vinculado:** `[fix: ...]`

---

## 3. Testes de Lista, Cards e Estado de Visualização (RF04 / RF11)
[cite_start]Verifica a conformidade dos dados exibidos, a estrutura dos cards e as restrições técnicas de desempenho[cite: 1213, 1335].

- [ ] **Item 3.1 — Quantidade Mínima de Dados Locais**
  * **Cenário de Teste:** Inicializar o app sem aplicar busca ou filtro.
  * [cite_start]**Comportamento Esperado:** A lista deve renderizar pelo menos 12 cursos cadastrados localmente com todos os metadados obrigatórios (id, nome, nome breve, categoria, nível, carga horária, descrição curta, descrição completa, status e progresso)[cite: 1212, 1213].
  * **Resultado Real:** ( ) Passou  |  ( ) Falhou  — Quantidade observada: ___
  * **Commit Vinculado:** `[data: ...]`

- [ ] **Item 3.2 — Exibição dos Estados de Disponibilidade**
  * **Comportamento Esperado:** Validação estrita das três strings mapeadas no modelo de dados para o status do card: `"Disponível"`, `"Em breve"` e `"Indisponível"`.
  * **Resultado Real:** ( ) Passou  |  ( ) Falhou
  * **Commit Vinculado:** `[data: ...]`

- [ ] **Item 3.3 — Uso Correto de LazyColumn**
  * [cite_start]**Cenário de Teste:** Rolar a lista rapidamente de cima para baixo e inspecionar a árvore de UI[cite: 1643].
  * **Comportamento Esperado:** O app deve usar obrigatoriamente `LazyColumn` para a lista principal (o uso de `Column` com scroll manual gera perda severa de pontos)[cite: 1542, 1643]. Desempenho fluído e sem travamentos.
  * **Resultado Real:** ( ) Passou  |  ( ) Falhou
  * **Commit Vinculado:** `[feat: ...]`

- [ ] **Item 3.4 — Alternância de Modo de Visualização Sem Perda de Estado**
  * [cite_start]**Cenário de Teste:** Digitar uma busca, alternar de "Cards" para "Lista" e vice-versa[cite: 1335, 1336].
  * [cite_start]**Comportamento Esperado:** O layout muda sua estrutura visual de acordo com o modo, mas mantém intactos o texto digitado no campo de busca e o filtro selecionado[cite: 1336].
  * **Resultado Real:** ( ) Passou  |  ( ) Falhou
  * **Commit Vinculado:** `[feat: ...]`

---

## 4. Testes de Mecanismo de Busca, Filtros e Estado Vazio (RF02 / RF03)
[cite_start]Valida a lógica algorítmica de manipulação de coleções e preservação de estado[cite: 1213, 1214, 1256].

- [ ] **Item 4.1 — Busca Case-Insensitive por Substring**
  * [cite_start]**Cenário de Teste:** Digitar `"android"` em minúsculas e `"ANDROID"` em maiúsculas[cite: 1257].
  * **Comportamento Esperado:** O resultado deve ser idêntico, ignorando maiúsculas/minúsculas, e encontrando correspondências parciais por nome, nome breve ou categoria[cite: 1213].
  * **Resultado Real:** ( ) Passou  |  ( ) Falhou
  * **Commit Vinculado:** `[feat: ...]`

- [ ] **Item 4.2 — Preservação da Lista Original (Imutabilidade)**
  * [cite_start]**Cenário de Teste:** Executar buscas consecutivas e depois limpar o campo de busca por completo[cite: 1255].
  * **Comportamento Esperado:** Ao limpar o campo, a lista completa é restaurada instantaneamente. [cite_start]A lista original de cursos nunca pode ser alterada ou limpa permanentemente da memória[cite: 1255, 1256].
  * **Resultado Real:** ( ) Passou  |  ( ) Falhou
  * **Commit Vinculado:** `[feat: ...]`

- [ ] **Item 4.3 — Combinação de Busca + Filtro (Operador AND)**
  * **Cenário de Teste:** Selecionar a categoria "Design" e digitar um termo que pertença à categoria "Programação"[cite: 1213, 1214].
  * [cite_start]**Comportamento Esperado:** A lista deve aplicar os filtros de forma combinada (interseção)[cite: 1215]. [cite_start]No cenário citado, deve disparar a tela de estado vazio imediatamente[cite: 1215].
  * **Resultado Real:** ( ) Passou  |  ( ) Falhou
  * **Commit Vinculado:** `[feat: ...]`

- [ ] **Item 4.4 — Comportamento de Estado Vazio**
  * **Cenário de Teste:** Digitar uma string aleatória inexistente (ex: `"XKZZY99"`)[cite: 1258].
  * [cite_start]**Comportamento Esperado:** A `LazyColumn` oculta seus itens e exibe centralizadamente os textos obrigatórios: `"Nenhum curso encontrado"` e `"Ajuste a busca ou altere o filtro selecionado."`[cite: 1677]. [cite_start]A tela não pode ficar em branco[cite: 1677].
  * **Resultado Real:** ( ) Passou  |  ( ) Falhou
  * **Commit Vinculado:** `[feat: ...]`

---

## 5. Testes de Seleção de Item e Navegação Segura (RF05 / RF06)
[cite_start]Verifica o desacoplamento de componentes da UI e o tráfego seguro de argumentos no Jetpack Navigation[cite: 1294, 1501].

- [ ] **Item 5.1 — Seleção Visual Exclusiva (State Hoisting)**
  * [cite_start]**Cenário de Teste:** Clicar em um card de curso para selecioná-lo e depois clicar em outro[cite: 1648, 1649].
  * **Comportamento Esperado:** O item clicado recebe o destaque visual (ex: alteração de cor de borda/background Material 3)[cite: 1647]. Apenas um item pode ficar selecionado por vez na árvore de estados[cite: 1650]. O card não controla o estado de seleção sozinho (aplica state hoisting)[cite: 1653, 1654].
  * **Resultado Real:** ( ) Passou  |  ( ) Falhou
  * **Commit Vinculado:** `[feat: ...]`

- [ ] **Item 5.2 — Navegação Sem Objeto Completo na Rota**
  * [cite_start]**Cenário de Teste:** Inspecionar a configuração do `NavHost` no código-fonte[cite: 1294, 1725].
  * [cite_start]**Comportamento Esperado:** A rota deve transportar apenas o argumento primitivo simples `cursoId` (ex: `"detalhe/{cursoId}"`)[cite: 1294]. [cite_start]É proibido por convenção competitiva trafegar objetos serializados inteiros ou JSON complexes em rotas Compose[cite: 1296, 1544].
  * **Resultado Real:** ( ) Passou  |  ( ) Falhou
  * **Commit Vinculado:** `[feat: ...]`

- [ ] **Item 5.3 — Desacoplamento do NavController no Card**
  * [cite_start]**Cenário de Teste:** Inspecionar a assinatura da função composable do Card de Curso[cite: 1501].
  * **Comportamento Esperado:** O componente do card não deve receber a instância do `NavController` diretamente[cite: 1503, 1545]. Ele deve expor uma função de callback lambda (ex: `onItemClick: (Int) -> Unit`), garantindo reuso e testabilidade isolada[cite: 1655].
  * **Resultado Real:** ( ) Passou  |  ( ) Falhou
  * **Commit Vinculado:** `[refactor: ...]`

- [ ] **Item 5.4 — Blindagem contra Null Safety e Chamadas Inseguras (`!!`)**
  * [cite_start]**Cenário de Teste:** Inspecionar o código de recuperação de argumentos na tela de detalhe.
  * [cite_start]**Comportamento Esperado:** É estritamente proibido o uso do operador de asserção não-nula `!!` ao ler o argumento vindo da rota. [cite_start]O app deve tratar nulos e conversões inválidas com segurança (`toIntOrNull()` ou fallbacks padrão).
  * **Resultado Real:** ( ) Passou  |  ( ) Falhou
  * **Commit Vinculado:** `[fix: ...]`

---

## 6. Testes de UI Automatizados (Melhoria de Nível Excelente)
[cite_start]Testes instrumentados que validam a árvore semântica do Compose UI Test[cite: 1374, 1375].

- [ ] **Item 6.1 — Teste de UI: Presença de Componentes Obrigatórios**
  * **Comportamento Esperado:** O teste automatizado localiza com sucesso o nó semântico com o texto `"Catálogo Aprender+"`[cite: 1374].
  * **Resultado Real:** ( ) Passou  |  ( ) Falhou  |  ( ) Não implementado
  * **Commit Vinculado:** `[test: ...]`

- [ ] **Item 6.2 — Teste de UI: Validação de Clique e Fluxo de Navegação**
  * [cite_start]**Comportamento Esperado:** O teste simula um toque (`performClick()`) em um card indexado e verifica se o nó semântico com a string título `"Detalhe do curso"` passa a existir na árvore visível[cite: 1374, 1375].
  * **Resultado Real:** ( ) Passou  |  ( ) Falhou  |  ( ) Não implementado
  * **Commit Vinculado:** `[test: ...]`

---

## 7. Relatório Técnico de Ocorrências e Controle de Danos

### A. Falhas e Erros Detectados Durante o Desenvolvimento
1. **Erro de Conversão de Tipo na Rota (03/06/2026):** O argumento enviado pela rota como String causava falha silenciosa ao buscar o ID do curso mapeado como Int. [cite_start]Afetou a tela `CourseDetailScreen`[cite: 1297, 1730].
2. [cite_start]**Recomposição Infinita no Filtro Combinado (04/06/2026):** A filtragem de listas de forma incorreta dentro do escopo de um Composable sem o uso correto do bloco `remember(searchQuery, selectedFilter)` disparava loops de recomposição travando a interface[cite: 1650].

### B. Correções Técnicas Aplicadas
1. [cite_start]**Solução da Conversão:** Substituição da captura direta por um tratamento defensivo usando `arguments?.getString("cursoId")?.toIntOrNull()`, aplicando um ID padrão inválido de fallback caso a conversão falhasse, exibindo graciosamente a mensagem `"Curso não encontrado"` em vez de quebrar o app[cite: 1297, 1730]. Commit: `[fix: trata conversão de argumento de navegação de forma segura]`.
2. **Solução da Recomposição:** Encapsulamento da lógica de filtragem combinada usando uma derivação direta do estado ou elevando o fluxo para um estado unificado imutável. [cite_start]Commit: `[refactor: otimiza recomposição utilizando estados derivados para busca e filtros]`.

### C. Limitações Conhecidas ou Pendências Técnicas Conscientes
* [cite_start]Os dados dos cursos são instanciados de forma local e imutável diretamente em memória (`hardcoded data source`), visto que persistência remota via APIs REST ou bancos de dados locais (Room) estão fora do escopo técnico definido para a atividade da Semana 04[cite: 1638].
