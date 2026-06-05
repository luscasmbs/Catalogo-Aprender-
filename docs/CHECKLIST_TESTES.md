# 📋 CHECKLIST_TESTES.md — Catálogo Aprender+

Este documento registra a execução sistemática dos testes manuais obrigatórios realizados no aplicativo **Catálogo Aprender+** (Semana 04 — Listas, estado e navegação em Compose). A estrutura unifica a agilidade das listas de tarefas nativas do Git (`- [ ]`) com o rigor de auditoria, metadados e rastreabilidade exigidos pelos critérios oficiais da WorldSkills.


---

## 1. Testes de Inicialização, Compilação e Ambiente

Mapeia a estabilidade básica do ecossistema e a integridade do ciclo de build.

- [x] **Item 1.1 — Sincronização do Motor Gradle**
  * **Cenário de Teste:** Importar o projeto no Android Studio e acionar `Sync Project with Gradle Files`.
  * **Comportamento Esperado:** Sincronização concluída com sucesso, sem falhas de dependências ou incompatibilidade de plugins. Dependências de Jetpack Compose, Material 3 e Navigation Compose resolvidas corretamente.
  * **Resultado Real:** (X) Passou  |  ( ) Falhou
  * **Evidência / Commit:** Ver histórico de commits e árvore de dependências resolvida no ambiente local.

- [x] **Item 1.2 — Compilação Limpa (Build Execution)**
  * **Cenário de Teste:** Executar `Build → Make Project` ou `AssembleDebug` via Gradle.
  * **Comportamento Esperado:** Geração completa do artefato final sem erros de compilação em código Kotlin ou na árvore de composables do Compose.
  * **Resultado Real:** (X) Passou  |  ( ) Falhou
  * **Evidência / Commit:** Build executado com sucesso e APK gerado na pasta de saídas padrão.

- [x] **Item 1.3 — Deploy e Instalação**
  * **Cenário de Teste:** Executar o app em emulador homologado (API 26+).
  * **Comportamento Esperado:** Transferência e instalação do APK concluídas sem erros de manifesto ou assinatura.
  * **Resultado Real:** (X) Passou  |  ( ) Falhou
  * **Evidência / Commit:** Deploy efetuado com sucesso no emulador alvo através do Android Studio.

- [ ] **Item 1.4 — Estabilidade de Inicialização (Anti-Crash)**
  * **Cenário de Teste:** Lançar o aplicativo a partir do launcher do sistema operacional Android.
  * **Comportamento Esperado:** A UI renderiza a tela de catálogo imediatamente. O app não sofre fechamento inesperado (*crash on startup*). A lista de cursos é exibida sem exigir ação do usuário.
  * **Resultado Real:** ( ) Passou  |  ( ) Falhou  |  (X) Não implementado *(Aguardando preenchimento da LazyColumn na CatalogScreen)*
  * **Evidência / Commit:** `CatalogScreen.kt` ainda possui blocos de listagem pendentes de unificação.

- [x] **Item 1.5 — Arquitetura de Inicialização Limpa**
  * **Cenário de Teste:** Inspeção estática no arquivo `MainActivity.kt`.
  * **Comportamento Esperado:** A `MainActivity` invoca `setContent` apenas para acionar o tema e o composable de navegação principal. Lógica de UI, estados e filtros devem estar desacoplados da Activity.
  * **Resultado Real:** (X) Passou  |  ( ) Falhou
  * **Evidência / Commit:** Lógica totalmente encapsulada nas Screens e componentes isolados em pacotes dedicados.

---

## 2. Interface Visual e Textos Obrigatórios Estritos

Validação de conformidade textual e presença de componentes para auditoria estrita de UI.

- [x] **Item 2.1 — Título Principal da Tela de Catálogo**
  * **Cenário de Teste:** Verificar visualmente o topo da hierarquia de componentes na tela principal ao abrir o app.
  * **Comportamento Esperado:** Exibição exata e literal da string: `"Catálogo Aprender+"`.
  * **Resultado Real:** (X) Passou  |  ( ) Falhou
  * **Evidência / Commit:** Validado no ficheiro `SearchHeader.kt` na linha 34: `text = "Catálogo Aprender+"`.

- [x] **Item 2.2 — Subtítulo Informativo da Tela de Catálogo**
  * **Cenário de Teste:** Verificar visualmente o texto de apoio posicionado abaixo do título principal.
  * **Comportamento Esperado:** Exibição exata e literal da string: `"Explore cursos técnicos e profissionalizantes."`.
  * **Resultado Real:** (X) Passou  |  ( ) Falhou
  * **Evidência / Commit:** Validado no ficheiro `SearchHeader.kt` na linha 44: `text = "Explore cursos técnicos e profissionalizantes."`.

- [x] **Item 2.3 — Placeholder do Campo de Busca**
  * **Cenário de Teste:** Analisar o estado inicial do campo de pesquisa de cursos.
  * **Comportamento Esperado:** O campo exibe como dica gráfica/placeholder o termo exato e literal: `"Busca"`.
  * **Resultado Real:** (X) Passou  |  ( ) Falhou
  * **Evidência / Commit:** Validado no ficheiro `BarSearch.kt` na linha 24: `Text(text = "Busca", color = LightBlue)`.

- [ ] **Item 2.4 — Opção de Filtro "Todos"**
  * **Cenário de Teste:** Verificar as pílulas de seleção de categoria (FilterChips) na tela principal.
  * **Comportamento Esperado:** Presença obrigatória de uma option de filtro estrita chamada `"Todos"`, selecionada por padrão ao inicializar.
  * **Resultado Real:** ( ) Passou  |  ( ) Falhou  |  (X) Não implementado
  * **Evidência / Commit:** O bloco correspondente na `CatalogScreen.kt` encontra-se sem a renderização do grupo de chips.

- [ ] **Item 2.5 — Contador de Cursos Exibidos**
  * **Cenário de Teste:** Analisar a interface imediatamente acima ou abaixo da lista de cursos.
  * **Comportamento Esperado:** Exibição de um componente de texto dinâmico que declare literalmente a quantidade de registros visíveis no formato: `"Cursos exibidos: X"` (onde X é o número inteiro corrente).
  * **Resultado Real:** ( ) Passou  |  ( ) Falhou  |  (X) Não implementado *(Texto de porcentagem foi incluído no card, mas não o contador geral exigido)*

- [ ] **Item 2.6 — Controles de Modo de Visualização**
  * **Cenário de Teste:** Identificar os botões de alternância gráfica de layout na barra superior ou de ferramentas.
  * **Comportamento Esperado:** Existência de dois botões clicáveis e icônicos para alternar o catálogo entre os modos de exibição em lista ou grade.
  * **Resultado Real:** ( ) Passou  |  ( ) Falhou  |  (X) Não implementado

- [ ] **Item 2.7 — Título Obrigatório da Tela de Detalhe**
  * **Cenário de Teste:** Clicar num item e inspecionar o topo da tela de destino.
  * **Comportamento Esperado:** A tela de detalhe deve conter um cabeçalho estrito exibindo textualmente a string literal: `"Detalhe do curso"`.
  * **Resultado Real:** ( ) Passou  |  ( ) Falhou  |  (X) Não implementado *(Aguardando construção da DetailScreen.kt)*

- [ ] **Item 2.8 — Texto Obrigatório da Trilha**
  * **Cenário de Teste:** Inspecionar as secções informativas na tela de detalhe do curso técnico.
  * **Comportamento Esperado:** Exibição em parágrafo destacado do aviso institucional literal: `"Este curso faz parte da trilha Aprender+."`.
  * **Resultado Real:** ( ) Passou  |  ( ) Falhou  |  (X) Não implementado

- [ ] **Item 2.9 — Mensagem Obrigatória de Curso Não Encontrado**
  * **Cenário de Teste:** Provocar uma falha de rota forçando um argumento identificador inválido ou inexistente na navegação do detalhe.
  * **Comportamento Esperado:** A tela não deve crashar, exibindo de forma limpa e centralizada o aviso estrito e literal: `"Curso não encontrado"`.
  * **Resultado Real:** ( ) Passou  |  ( ) Falhou  |  (X) Não implementado *(O StatusCard.kt possui a estrutura de mensagem genérica para formulários, mas a regra de erro de ID de curso ainda não foi vinculada ao fluxo de navegação)*

---

## 3. Comportamento de Listagem Eficiente e Cards Dinâmicos

Avalia a renderização de grandes volumes de dados através de ecossistemas otimizados.

- [ ] **Item 3.1 — Exibição de Nome Completo e Nome Curto**
  * **Cenário de Teste:** Visualizar os cards renderizados na listagem ativa.
  * **Comportamento Esperado:** Cada item exibe obrigatoriamente tanto o nome completo (`completename`) quanto a sigla/nome curto (`shortname`) em posições de destaque hierárquico distintas.
  * **Resultado Real:** ( ) Passou  |  ( ) Falhou  |  (X) Não implementado *(O CourseCard.kt exibe completename, mas a inserção da sigla curta na árvore visual não foi concluída)*

- [ ] **Item 3.2 — Exibição Otimizada de Metadados nos Cards**
  * **Cenário de Teste:** Inspecionar visualmente o rodapé informacional ou os chips internos de um card de curso no catálogo.
  * **Comportamento Esperado:** Exibição legível dos metadados de Carga Horária (ex.: `1200h`), Categoria e Nível de Dificuldade.
  * **Resultado Real:** ( ) Passou  |  ( ) Falhou  |  (X) Não implementado *(Implementado de forma estática no preview de CourseCards.kt, mas necessita de mapeamento dinâmico na LazyColumn)*

- [ ] **Item 3.3 — Uso Mandatório de LazyColumn**
  * **Cenário de Teste:** Inspeção estática no ficheiro que monta o container da lista de cursos.
  * **Comportamento Esperado:** Uso estrito do componente nativo `LazyColumn` (ou `LazyVerticalGrid` se em modo de grade) para reciclagem de views sob demanda. É expressamente proibido o uso de `Column` tradicional acompanhada de modificadores de rolagem vertical manual (`verticalScroll`) sobre a coleção de dados principal.
  * **Resultado Real:** ( ) Passou  |  ( ) Falhou  |  (X) Não implementado *(O ficheiro esqueleto CourseCards.kt usou Column com verticalScroll, o que precisará ser substituído por LazyColumn para homologação)*

---

## 4. Algoritmo de Busca, Filtragem Combinada e Estado Vazio

Verifica a reatividade em tempo de execução dos algoritmos de consulta.

- [ ] **Item 4.1 — Filtro por Digitação Insensível a Caixa (Case-Insensitive)**
  * **Cenário de Teste:** Digitar termos como `"SISTEMAS"`, `"sistemas"` ou `"SiStEmAs"` no campo de busca.
  * **Comportamento Esperado:** O catálogo reage instantaneamente filtrando os mesmos resultados em todos os cenários, comprovando o uso correto de funções de correspondência como `.contains(query, ignoreCase = true)`.
  * **Resultado Real:** ( ) Passou  |  ( ) Falhou  |  (X) Não implementado

- [ ] **Item 4.2 — Preservação Íntegra da Coleção Original**
  * **Cenário de Teste:** Digitar um critério de busca, apagar o texto por completo através do teclado ou limpar o campo.
  * **Comportamento Esperado:** A listagem original com todos os cursos disponíveis é completamente restaurada na tela sem perdas de referências ou necessidade de reinicializar a aplicação.
  * **Resultado Real:** ( ) Passou  |  ( ) Falhou  |  (X) Não implementado

- [ ] **Item 4.3 — Intersecção Acumulada de Filtros (Busca + Categoria)**
  * **Cenário de Teste:** Selecionar uma categoria específica (ex: "Programação") e, em seguida, digitar um termo de busca no campo de texto.
  * **Comportamento Esperado:** O app deve aplicar os dois critérios de forma cumulativa (operação lógica AND), exibindo apenas cursos que pertençam à categoria selecionada E que possuam o termo digitado no nome.
  * **Resultado Real:** ( ) Passou  |  ( ) Falhou  |  (X) Não implementado

- [ ] **Item 4.4 — Tela de Estado Vazio ("Nenhum curso encontrado")**
  * **Cenário de Teste:** Digitar uma sequência aleatória absurda de caracteres no campo de busca (ex: `"xyz123abc"`).
  * **Comportamento Esperado:** A interface oculta a lista de cards e exibe um componente de feedback limpo contendo o texto centralizado `"Nenhum curso encontrado"`, prevenindo uma tela branca sem explicação ao usuário.
  * **Resultado Real:** ( ) Passou  |  ( ) Falhou  |  (X) Não implementado

---

## 5. Testes de Seleção de Item e Navegação Segura

Auditoria do fluxo transacional entre telas e elevação correta de estados em Compose.

- [ ] **Item 5.1 — Feedback Visual de Seleção Local**
  * **Cenário de Teste:** Realizar um clique simples num card de curso na lista e observar as suas bordas ou background antes da transição.
  * **Comportamento Esperado:** O card clicado recebe imediatamente um realce cromático de seleção (mudança de cor de fundo ou ativação de borda com cor contrastante), indicando o foco do estado ativo.
  * **Resultado Real:** ( ) Passou  |  ( ) Falhou  |  (X) Não implementado *(O CourseCard.kt aceita a flag `select: Boolean`, mas o estado persistente que altera este valor na lista ainda não foi conectado)*

- [ ] **Item 5.2 — Passagem Primitiva de Argumento via Rota**
  * **Cenário de Teste:** Avaliar a navegação para a tela de detalhe através do clique.
  * **Comportamento Esperado:** O identificador numérico único do curso (`id: Int` ou `courseId`) deve ser concatenado de forma segura na string de rota (ex: `"courseDetail/{courseId}"`), evitando a passagem indevida de objetos complexos serializados na URI da rota.
  * **Resultado Real:** ( ) Passou  |  ( ) Falhou  |  (X) Não implementado

- [x] **Item 5.3 — Desacoplamento do NavController no Card (State Hoisting)**
  * **Cenário de Teste:** Inspeção estática na assinatura e parâmetros do componente `CourseCard.kt` e `PreviewRegisterCard.kt`.
  * **Comportamento Esperado:** O card reutilizável não deve instanciar ou receber diretamente uma instância de `NavController`. O evento de clique deve ser elevado obrigatoriamente através de um lambda callback purificado (ex: `onclick: () -> Unit`).
  * **Resultado Real:** (X) Passou  |  ( ) Falhou  
  * **Evidência / Commit:** Assinatura do `CourseCard` segue perfeitamente o padrão de State Hoisting: `fun CourseCard(..., onclick: () -> Unit)`.

---

## 6. Persistência de Estado e Robustez a Eventos de Sistema

Garante a retenção correta dos dados em cenários críticos de ciclo de vida.

- [ ] **Item 6.1 — Sobrevivência à Rotação de Tela (Retrato/Paisagem)**
  * **Cenário de Teste:** Digitar um texto no campo de busca, selecionar um filtro de categoria e rotacionar o emulador de modo Vertical (Portrait) para Horizontal (Landscape).
  * **Comportamento Esperado:** A interface é reconstruída mantendo exatamente o mesmo texto digitado na busca e o mesmo filtro selecionado, comprovando a aplicação correta de `rememberSaveable`.
  * **Resultado Real:** ( ) Passou  |  ( ) Falhou  |  (X) Não implementado

- [ ] **Item 6.2 — Preservação do Filtro no Retorno da Navegação**
  * **Cenário de Teste:** Filtrar a lista, clicar em um curso para abrir a tela de detalhe e, em seguida, acionar o botão nativo de voltar do Android ou a seta de retorno da UI.
  * **Comportamento Esperado:** O utilizador regressa à tela de catálogo e encontra exatamente o mesmo estado de busca e filtragem de itens que configurou antes de sair da tela, evitando reinicializações frustrantes no fluxo de exploração.
  * **Resultado Real:** ( ) Passou  |  ( ) Falhou  |  (X) Não implementado

---
