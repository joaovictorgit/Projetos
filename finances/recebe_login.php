<?php
    $host = 'localhost';
    $user = 'root';
    $pass = ' ';
    $database = '';

    $mysqli = new mysqli($host,$user,$pass,$database);

    if($mysqli-> connect_errno){
        echo"Conexão inválida"     ; 
    }

?>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
      <title>Login</title>
   <script type="text/javascript">
     function loginsuccessfuly(){
      setTimeout("window.location='MinhaConta.php'",4000);
             }    
     function loginfailed(){
      setTimeout("window.location='AreaRestrita.php'",4000);
             }    
   </script> </head>
    <body>
        <?php
        $login = $_POST['username'];
        $senha = $_POST['password'];
        $sql = $mysqli_query("SELECT * FROM finances WHERE login ='$login' and senha ='$senha' ") or die ($mysqli->error);
        
        $row = mysql_num_rows($sql);
        if($row){
            session_start();
           $_SESSION['logar'] = $_POST['username'];
           $_SESSION['senha'] = $_POST['password'];     
            echo 'Usuario logado com sucesso!! Aguarde';
            echo '<script>loginsuccessfuly()</script>';
        }else {
            echo 'Login e Senha incorretos!! Aguarde';
            echo '<script>loginfailed()</script>';
        
        
        ?>
    </body>
</html>