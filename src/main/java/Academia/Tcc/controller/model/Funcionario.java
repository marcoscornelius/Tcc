package Academia.Tcc.controller.model;


public class Funcionario {
    public Integer id;
    public String nome;
    public String endereco;
    public String telefone;
    public String cpf;
    public String horario_entrada;
    public String horario_saida;
    public String funcao;

    public Funcionario() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getHorarioEntrada() {
        return horario_entrada;
    }

    public void setHorarioEntrada(String horarioEntrada) {
        this.horario_entrada = horarioEntrada;
    }

    public String getHorarioSaida() {
        return horario_saida;
    }

    public void setHorarioSaida(String horarioSaida) {
        this.horario_saida = horarioSaida;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
}
