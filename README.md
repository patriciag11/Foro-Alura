# Foro-Alura
Foro para crear, mostrar, actualizar y eliminar tópicos
                                    
                                    
                                  REGISTRAR UN TOPICO
 Al enviar un formato Json con los datos que queremos que nos guarde el tópico. Nos da un mensaje 200 ok

 ![image](https://github.com/patriciag11/Foro-Alura/assets/121626543/00c6e1e5-0009-4c4a-83c8-76bacff2c9f2)

Y revisamos el registro 11 creado en la base de datos con el título que enviamos:

![image](https://github.com/patriciag11/Foro-Alura/assets/121626543/5f8e3b8c-f815-4101-aeed-7638146609ad)

                                     LISTADO

En el listado hacemos una muestra de todos los tópicos existentes pero se los ordenó por título

![image](https://github.com/patriciag11/Foro-Alura/assets/121626543/f54be6a0-ed6e-4c65-b9e5-e7154e2818d3)

                                    ACTUALIZAR

En este caso hicimos que se pueda actualizar el título o el mensaje pero para ello es indispensable que pasemos como parámetro el Id del tópico,  en este caso vamos a escoger el id=3:
 
 ![image](https://github.com/patriciag11/Foro-Alura/assets/121626543/6fe164ae-bd14-44a7-b6d2-54b1bf5e18ee)

Vamos a editar el título, le colocaremos Update: 
 
 ![image](https://github.com/patriciag11/Foro-Alura/assets/121626543/2bda7785-76e6-4a5c-b40b-38b720b4b890)

Vemos que al listar el registro 3 muestra su nuevo título Update:
 
 ![image](https://github.com/patriciag11/Foro-Alura/assets/121626543/fdf90d49-721e-4ac5-b175-55c1adba980d)

                                  DELETE EN BASE DE DATOS

Con esta opción que no la dejamos activa, sino que solamente probamos el borrado en la base de datos optamos por borrar el registro 1

![image](https://github.com/patriciag11/Foro-Alura/assets/121626543/dc5b4e4e-eac4-410d-9277-afadbb946ff4)

 
Hacemos el llamado a DELETE: http://localhost:8080/topico/1 y enviamos:

![image](https://github.com/patriciag11/Foro-Alura/assets/121626543/ddd597f4-82ca-4e3b-ac37-54bf0154aafd)
 
Y verificamos que en el listado ya no se muestra el registro 1

![image](https://github.com/patriciag11/Foro-Alura/assets/121626543/25176fd3-a4c2-4d50-a94b-fe0a152c086c)

Y también  en la base de datos hacemos un select de los foros registrados en la tabla tópicos, y no se muestra el registro 1.
 
![image](https://github.com/patriciag11/Foro-Alura/assets/121626543/7f791ef5-77cb-49cd-b7cd-41b73c4430b0)

                                            DELETE LÓGICO 

Con este delete lógico, lo que se hace es crear una variable de que si el foro está activo o no,  dependiendo de ello se lo muestra en el listado

![image](https://github.com/patriciag11/Foro-Alura/assets/121626543/8b9db932-5b68-4b8f-90ec-ad08ca3901d7)

Se realiza el borrado del registro 2:

![image](https://github.com/patriciag11/Foro-Alura/assets/121626543/efdce07d-b35d-4ffa-8b3b-d832afe53106)
 
Y vemos que en el listado no se muestra, sin embargo;

![image](https://github.com/patriciag11/Foro-Alura/assets/121626543/d420ba11-d762-4beb-8bc7-e17977d0f92e)

Consta en la base de datos pero con estado Activo en 0, por tanto el listado ya no se muestra:

![image](https://github.com/patriciag11/Foro-Alura/assets/121626543/171d744f-cd73-4d72-bc33-b5d1cae2f118)
 
                                            LISTAR POR ID
                                            
Aquí hacemos un GET con la dirección: http://localhost:8080/topico/3;  y en efecto nos muestra solamente el registro 3 del foro

![image](https://github.com/patriciag11/Foro-Alura/assets/121626543/f258344f-fea8-47b1-b009-2e91ba9966a9)

 

