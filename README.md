# Catálogo Aprender+

Aplicativo Android desenvolvido em Kotlin com Jetpack Compose, Material 3 e Navigation Compose para apresentar um catálogo local de cursos técnicos e profissionalizantes da plataforma fictícia Aprender+.

O projeto atende ao briefing da Semana 04 - Listas, estado e navegação em Compose, com foco em lista de cursos, busca, filtro, seleção visual, navegação lista-detalhe e tratamento de curso inexistente.

## Como executar

1. Abra o projeto no Android Studio em versão estável.
2. Aguarde o Sync do Gradle finalizar.
3. Selecione um emulador ou dispositivo Android.
4. Execute o app pelo botão Run do Android Studio.

Execução por terminal no Windows:

```powershell
$env:JAVA_HOME='C:\Program Files\Android\Android Studio\jbr'
.\gradlew.bat assembleDebug
```

Testes unitários:

```powershell
$env:JAVA_HOME='C:\Program Files\Android\Android Studio\jbr'
.\gradlew.bat testDebugUnitTest
```

Observação: no ambiente usado para validação, o `JAVA_HOME` global apontava para um diretório inválido. Por isso, os comandos acima definem temporariamente o JDK do Android Studio.

## Funcionalidades implementadas

- Tela principal com o título `Catálogo Aprender+`.
- Texto de apoio `Explore cursos técnicos e profissionalizantes.`.
- Campo de busca com placeholder `Busca`.
- Lista vertical de cursos em cards.
- Pelo menos 12 cursos cadastrados localmente.
- Busca por nome, nome breve, descrição, categoria, nível e status.
- Filtro visual por categoria.
- Contador dinâmico no formato `Cursos exibidos: X`.
- Estado vazio quando a lista filtrada não possui resultados.
- Seleção visual de card.
- Navegação para detalhe usando o identificador do curso.
- Tela `Detalhe do curso`.
- Texto obrigatório `Este curso faz parte da trilha Aprender+.`.
- Tratamento seguro para curso inexistente.
- Botão `Voltar` na tela de detalhe.
- Checklist e arquivo de evidências visuais.

## Arquitetura e organização

A estrutura principal do projeto está organizada por responsabilidade:

| Pacote/pasta | Responsabilidade |
| --- | --- |
| `model` | Modelos e enums usados pelos cursos. |
| `data` | Repositório local de cursos. |
| `domain` | Função de filtro e regra de busca. |
| `ui.screens` | Telas principais do app. |
| `ui.components` | Componentes reutilizáveis de catálogo, detalhe e cadastro. |
| `navigation` | Configuração do fluxo de navegação. |
| `ui.theme` | Cores, tema e tipografia. |
| `docs` | Checklist de validação. |
| `evidencias` | Vídeo e prints da execução. |

O app mantém a lista original no repositório local e deriva a lista exibida a partir do estado atual de busca e filtro. Assim, limpar a busca ou alterar o filtro não destrói os dados originais.

## Modelo de dados

Cada curso possui os campos necessários para lista e detalhe:

- `id`
- `completename`
- `shortname`
- `type`
- `level`
- `worktime`
- `shortdescription`
- `longdescription`
- `availability`
- `percentageprogress`

As categorias e status usam enums para reduzir strings soltas no código. Os status exibidos são:

- `Disponível`
- `Em breve`
- `Indisponível`

## Estado em Compose

A tela de catálogo controla o estado principal usando `rememberSaveable`:

- texto digitado na busca;
- categoria selecionada no filtro;
- curso selecionado visualmente.

O componente de busca recebe `value` e `onValueChange` por parâmetro, aplicando state hoisting. O card de curso também recebe estado e evento por parâmetro, sem controlar a navegação internamente.

## Busca e filtros

A função `filterCourses` centraliza a lógica de busca e filtro.

A busca ignora maiúsculas e minúsculas e considera:

- nome completo;
- nome breve;
- descrição curta;
- descrição longa;
- categoria;
- nível;
- status.

O filtro por categoria funciona junto da busca por meio de uma regra cumulativa: o curso precisa atender ao texto digitado e à categoria selecionada.

## Navegação

O app usa Navigation Compose com fluxo principal de catálogo para detalhe.

Rotas atuais:

| Rota | Função |
| --- | --- |
| `Catalog` | Tela principal do catálogo. |
| `CourseRegister` | Tela de cadastro de curso. |
| `Details/{courseId}` | Tela de detalhe com argumento do curso. |

A tela de detalhe recebe o `courseId`, converte o argumento com segurança usando `toIntOrNull()` e busca o curso correspondente no repositório. Quando o identificador é inválido ou não existe, a tela exibe `Curso não encontrado`.

## Testes realizados

Há testes unitários para a regra de filtro e para a base local de cursos:

- lista inicial com 12 cursos;
- busca vazia retornando todos os cursos;
- busca por nome;
- busca por categoria;
- filtro por categoria;
- busca inexistente retornando lista vazia;
- busca e filtro funcionando juntos.

Comando usado na validação local:

```powershell
$env:JAVA_HOME='C:\Program Files\Android\Android Studio\jbr'
.\gradlew.bat testDebugUnitTest
```

Resultado observado: `BUILD SUCCESSFUL`.

## Evidências

As evidências visuais estão documentadas em:

- `EVIDENCIAS.md`
- `evidencias/video-demo.mp4`
- `evidencias/prints/`

O arquivo `EVIDENCIAS.md` relaciona cada print aos requisitos/checklist comprovados pelo vídeo.

## Limitações e pontos de atenção

- O modo opcional de alternância `Cards`/`Lista` não foi documentado como implementado.
- Existem evidências visuais do app em execução em `EVIDENCIAS.md`.
- A gravação analisada não mostrou claramente o cenário específico de busca sem resultado com `Nenhum curso encontrado`.
- A gravação analisada não mostrou claramente o cenário específico de tratamento visual `Curso não encontrado`.
- O funcionamento do botão `Voltar` aparece como ação disponível, mas deve ser confirmado por teste manual se a gravação não mostrar o retorno.
- O `minSdk` atual do projeto está configurado como API 33. O briefing recomenda Android 8.0 ou superior, que corresponde à API 26.
- A opção geral do filtro deve ser conferida contra o texto obrigatório do briefing: `Todos`.
- As rotas funcionam, mas podem ser melhoradas centralizando strings em um objeto, classe selada ou estrutura equivalente.

## Checklist e evidências de entrega

O checklist principal da entrega está em `docs/CHECKLIST_TESTES.md`.

As evidências visuais estão em `EVIDENCIAS.md`, com prints extraídos de `evidencias/video-demo.mp4` e imagens salvas em `evidencias/prints/`.
