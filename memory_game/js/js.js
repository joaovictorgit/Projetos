function exibi(){
    var nome = form.nome.value;
    var sobrenome = form.sobrenome.value;
    var email = form.email.value;
    var senha = form.senha.value;
    

    
    if(nome==""){
        alert("Preencha o campo Nome");
        form.nome.focos();
        return false;
    }
     if(sobrenome==""){
        alert("Preencha o campo Sobrenome");
        form.sobrenome.focos();
        return false;
    }
     if(email==""){
        alert("Preencha o campo Email");
        form.email.focos();
        return false;
    }
     if(senha==""){
        alert("Preencha o campo Senha");
        form.senha.focos();
        return false;
    }
      
}


