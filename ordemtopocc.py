from digraph import Digraph
from ordtopologica import OrdTopologica

if __name__ == "__main__":

    g = Digraph()   

    # Ler cada linha do arquivo exemplo/curriculo_98aj.txt
    # Em cada linha (strings separadas por "/")
    #     - Primeira string é a disciplina destino
    #     - Próximas strings são os pré-requisitos
    # Gerar uma aresta de cada pré-requisito para a disciplina

    # Gerar o grafo em formato dot (opcional,
    # para facilitar a visualização)
    # print(g.toDot())

    # Executar ordenação topológica
    ot = OrdTopologica(g)

    print("Ordem topológica:")
    for v in ot.ordem():
        print("->", v)