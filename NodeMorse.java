class NodeMorse {
    char letra;
    NodeMorse esquerda;
    NodeMorse direita;
    public NodeMorse(char letra) {
        this.letra = letra;
        this.esquerda = null;
        this.direita = null;
    }
}