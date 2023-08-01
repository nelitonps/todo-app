export interface Todo{
    //O sinal ? significa que a variavel não é de uso obrigatório
    id?: String,
    titulo: String,
    descricao?: String,
    dataFinalizar: any,
    finalizada: Boolean
}