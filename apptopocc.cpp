#include <iostream>
#include "digraph.h"
#include "topological.h"

using namespace std;

int main()
{
  Digraph g;

  // Ler cada linha do arquivo exemplo/curriculo_98aj.txt
  // Em cada linha (strings separadas por "/")
  //     - Primeira string é a disciplina destino
  //     - Próximas strings são os pré-requisitos
  // Gerar uma aresta de cada pré-requisito para a disciplina

  // Gerar o grafo em formato dot (opcional,
  // para facilitar a visualização)
  // cout << g.toDot();

  // Executar ordenação topológica
  Topological topo(g);

  for (auto const &v : topo.getTopological())
    cout << v << " ";
  cout << endl;
}
