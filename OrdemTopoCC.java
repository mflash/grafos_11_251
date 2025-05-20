public class OrdemTopoCC
{
    public static void main(String[] args) {
        Digraph g = new Digraph();
        // Ler cada linha do arquivo exemplo/curriculo_98aj.txt
        // Em cada linha (strings separadas por "/")
        //     - Primeira string é a disciplina destino
        //     - Próximas strings são os pré-requisitos
        // Gerar uma aresta de cada pré-requisito para a disciplina

        // Gerar o grafo em formato dot (opcional,
        // para facilitar a visualização)
        // System.out.println(g.toDot());

        // Executar ordenação topológica
        OrdemTopologica ot = new OrdemTopologica(g);
        for(String v: ot.getOrdemTopologica()) {
            System.out.println(v+", ");
        }
    }
}