package Usuario

class Usuario {
    val email : String
    val nombre : String
    val apellido : String

    constructor() {
        email = ""
        nombre = ""
        apellido = ""
    }

    constructor(email : String, nombre : String, apellido : String) {
        this.email = email
        this.nombre = nombre
        this.apellido = apellido
    }
}