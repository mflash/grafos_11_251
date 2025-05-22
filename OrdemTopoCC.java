public class OrdemTopoCC {
    public static void main(String[] args) {
        Digraph g = new Digraph();
        // Ler cada linha do arquivo exemplo/curriculo_98aj.txt
        // Em cada linha (strings separadas por "/")
        // - Primeira string é a disciplina destino
        // - Próximas strings são os pré-requisitos
        // Gerar uma aresta de cada pré-requisito para a disciplina
        In arq = new In("exemplos/curriculo_98aj.txt");
        while (arq.hasNextLine()) {
            String linha = arq.readLine();
            String[] aux = linha.split("/");
            String destino = aux[0];
            for (int pos = 1; pos < aux.length; pos++) {
                String origem = aux[pos];
                g.addEdge(origem, destino);
            }
        }

        // Gerar o grafo em formato dot (opcional,
        // para facilitar a visualização)
        System.out.println(g.toDot());

        // Executar ordenação topológica
        OrdemTopologica ot = new OrdemTopologica(g);
        for (String v : ot.getOrdemTopologica()) {
            System.out.println(v + ", ");
        }
    }
}