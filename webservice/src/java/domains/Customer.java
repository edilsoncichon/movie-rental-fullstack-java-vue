package domains;

public class Customer {
    private int id;
    private String name;
    private String cpf;
    private String dtNascimento;
    private String endereco;
    private String sexo;
    private String tipo;
    private String comunicados;
    private String obs;

    public Customer(String name, String cpf, String dtNascimento, String endereco, String sexo, String tipo, String comunicados, String obs) {
        this.name = name;
        this.cpf = cpf;
        this.dtNascimento = dtNascimento;
        this.endereco = endereco;
        this.sexo = sexo;
        this.tipo = tipo;
        this.comunicados = comunicados;
        this.obs = obs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(String dtNascimento) {
        this.dtNascimento = dtNascimento;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getComunicados() {
        return comunicados;
    }

    public void setComunicados(String comunicados) {
        this.comunicados = comunicados;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    @Override
    public String toString() {
        return this.getCpf().concat(" - ").concat(this.getName());
    }
    
}
