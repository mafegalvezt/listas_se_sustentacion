package com.umanizales.lists_prog2.model.listade;

import com.umanizales.lists_prog2.exception.ListaDeException;
import com.umanizales.lists_prog2.exception.ListaSeException;
import com.umanizales.lists_prog2.model.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ListaDE {
    private String RH;
    private Node head;
    private int count;

    public void add(Boy boy)
    {
        if(this.head!=null)
        {
            Node temp = this.head;
            while(temp.getNext()!=null)
            {
                temp = temp.getNext();
            }
            Node newBoy= new Node(boy);
            temp.setNext(newBoy);
            newBoy.setPrevious(temp);
        }
        else
        {
            //NO hay datos
            this.head= new Node(boy);
        }
    }

        //@param metodo que permite adicionar un nodo al inicio de la lista
        public void addToStart(Boy boy) {
            //verifica si la lista esta vacia
            if (head != null) {
                //SI hay datos
                Node temp = new Node(boy); /** agrega el nuevo nodo */
            temp.setNext(head);/** el temporal agarra el brazo del siguinte */
            head.setPrevious(temp); /** la cabeza toma el brazo anterior del temporal */
            // la cabeza es el temporal/
            head = temp;
            } else {
                //si la lista esta vacia el nuevo niño es la cabeza/
                head = new Node(boy);
            }
        }

        public int countNodesDE() { /**@param metodo para contar los nodos de la lista  */

            if (head != null) { /**pregunta si la lista esta vacia */
                Node temp = head; /** el nodo temporal se para en cabeza */
                //el contador es igual a 1/
                int cont = 1;

                while (temp.getNext() != null) { /**temporal recorre la lista y si el siguiente del temporal
                 esta lleno el contador se aumenta*/
                temp = temp.getNext();
                cont++;
            }
            return cont; /**@return se muestra en cuanto queda el contador */
        } else {
            return 0; /**si el contador no aunemta se muestra 0 */
        }
    }



    public void delete(String identification) { /** @param metodo para eliminar un nodo por identificacion */

        Node previous = head; /** nos paramos en la cabeza */
        if (previous.getData().getIdentification() == identification) { /** pregunta si la identificicacion del nodo
         es igual a la que se quiere eliminar*/
        }
        else
        {

            while (previous.getNext().getData().getIdentification() != identification) {
                /** si la identificacion no es la necesitada pasa al siguiente nodo */
                previous = previous.getNext();
            }

            if (previous.getNext().getNext() == null) { /** cuando se encuentra el necesitado el brazo
             anterior del nodo siguiente toma al nodo*/
                previous.setNext(null);/** el nodo se suelta */
            } else {
                previous.setNext(previous.getNext().getNext()); /** se enlazan el siguiente del eliminado
                 con el anterior al aliminado*/

            }
        }

    }

    // @param metodo para eliminar un nodo en una posicicon especifica/
    public void deleteByPositionDE(byte position) {

            if (head != null) { /** se verifica que la lista tenga mas de un elemento */
            // si la lista solo tiene un elemto se elimina la cabeza/
        if (head.getNext() == null) {
                    head = null;
//            ListaDE nueva=new ListaDE();
                } else {

                    Node temp = head;
                    int cont = 1;

                    if (cont == position) {
                        //Eliminar cabeza

                        head = temp.getNext();

                        head.setPrevious(null);

                    } else {
                        while (position != cont) {
                            temp = temp.getNext();
                            cont++;
                        }
                        if (temp.getNext() == null) {
                            temp.getPrevious().setNext(null);

                        } else {
                            temp.getNext().setPrevious(temp.getPrevious());
                            temp.getPrevious().setNext(temp.getNext());
                        }
                    }
                }
            }
        }



        public void changepositions(int pos1, int pos2) {
            byte cont1 = 1;
            byte cont2 = 1;
            Node temp1 = head;
            Node temp2 = head;

            //Ubicar el temporal 1 en la posicion 1 buscada
            while (cont1 != pos1) {
                temp1 = temp1.getNext();
                cont1++;
            }
            //Ubicar el temporal 1 en la posicion 2 buscada
            while (cont2 != pos2) {
                temp2 = temp2.getNext();
                cont2++;
            }

            //Tomar los datos (lo que hay dentro de los nodos) e intercambiarlos, los nodos no se mueven
            Boy temp = temp1.getData();
            temp1.setData(temp2.getData());
            temp2.setData(temp);
        }

        //Pedir la posición en donde va a ir el nodo
        //Preguntar si la lista esta vacía
        //  Si está vacía, ubicar el nodo en la cabeza
        //Si la posicion dada es igual a 1 agregar el nodo en la primera posición, con cabeza.setAnterior nodo nuevo
        //nodo nuevo.set siguiente cabeza
        // Hacer cabeza igual a nodo nuevo
        //Agragar un contador que inicie en 0 y un temporal para recorrer la  lista
        //Recorrer la lista
        //En caso que el contador sea igual a la psoición menos 1, ubicase ahí
        //al siguiente del temporal cambiar el lazo anterior y unirlo con el nodo nuevo
        // y el nodo nuevo cambiar el lazo siguiente por el seiguiente a temporal
        //Al nodo nuevo cambiar el lazo anterior por el temporal
        //A temporal cambiar el seguiente por el nodo nuevo

        public void addNode(int pos, Boy boy) {
            if (head != null) {
                int cont = 1;
                Node temp = head;
                if (pos == cont) {
                    addToStart(boy);
                } else {
                    while (cont != pos && temp.getNext() != null) temp = temp.getNext();
                    cont++;
                }
                if (cont < pos) {
                    addNode(boy);
                } else {
                    temp = temp.getPrevious();
                    temp.setPrevious(new Node(boy));
                    temp.getPrevious().setPrevious(temp);
                    temp.setNext(temp.getPrevious());
                    temp.getPrevious().setNext(temp);

                }
            } else {
                addNode(boy);

            }
        }

    private void addNode(Boy boy) {
    }

    public void invertDE() {
            if (head != null) {
                ListaDE listTempDE = new ListaDE();
                Node temp = head;
                while (temp != null)//Recorre de principio a fin
                {
                    listTempDE.addToStart(temp.getData());
                    temp = temp.getNext();//Ayudante pase al siguiente
                }
                head = listTempDE.getHead();
            }
        }

        public Boy findPosition(byte numberNode) { /**@param metodo para encontrar un nodo por posicion */

            if (head!= null) {  /**  */
                Node temp = head;
                int cont = 1;
                while (numberNode != cont) {
                    temp = temp.getNext();
                    cont++;
                }
                return temp.getData();
            }
            return null;
        }

    //metodo que me retorna tomando grado y ubicacion cuantos niños y cuantas niñas hay.
   /** public GendersByGradeDTO getGenderByGradeByLocation (byte grade, Location location) throws ListaDeException
    {
        validateListEmpty();
        int countTotal=0;
        int countM=0;
        int countF=0;
        Node temp = this.head;
        while(temp!=null)
        {
            if(temp.getData().getLocation().getCode().equals(location.getCode())
                    && temp.getData().getGrade()==grade)
            {
                countTotal++;
                if (temp.getData().isOrphan())
                {
                    if (temp.getData().getGender().equals(Gender.MASCULINO))
                    {
                        countM++;
                    }
                    else
                    {
                        countF++;
                    }
                }
            }
            temp=temp.getNext()
        }
        List<CountByGenderDTO> countByGenderDTO= new ArrayList<>();
        countByGenderDTO.add(new countByGenderDTO(Gender.MASCULINO,countM));
        countByGenderDTO.add(new CountByGenderDTO(Gender.FEMENINO,countF));
        GendersByGradeDTO gendersByGradeDTO = new GendersByGradeDTO(grade,countByGenderDTO, countTotal);
        return gendersByGradeDTO;
    }**/

    /**public GradeByLocationDTO getGradeByLocation(Location location) throws ListaDeException
    {

        List<GendersByGradeDTO> gendersByGradeDTOS = new ArrayList<>();
        for(byte i=1; i<=5; i++)
        {
            gendersByGradeDTOS.add(getGenderByGradeByLocation(1,location))
        }
        GradeByLocationDTO gradeByLocationDTO = new GradeByLocationDTO(location, gendersByGradeDTOS);
        return gradeByLocationDTO;

    }

    public void validateListEmpty() throws ListaDeException
    {
        if(this.head==null)
        {
            throw new ListaDeException("No hay datos en la lista");
        }
    }**/

    //metodo del primer ejercicio, que me permite recibir un parametro para listar municipios ordenados.
    /** pongo mi nodo temporal en la cabeza
     despues creo un arreglo donde pongo los niños de chinchina
     des pues de agregar uno, sigo agregando el siguiente mientras el temp no este vacio
     y finalmente me retorna la lista de niños de chinchina y se repite el mismo proceso con los demas municipios
     **/
    public List<Boy> listBoyChinchina (){
        Node temp = head;
        List<Boy> listBoysChinchina = new ArrayList<>();
        temp = temp.getNext();
        while(temp.getNext() != null ){
            if(equals(Object.equals(temp.getData().getLocation(), "chinchina"))){
                listBoysChinchina.add(temp.getData());
            }
        }
        return  listBoysChinchina;
    }

    /** pongo mi nodo temporal en la cabeza
     despues creo un arreglo donde pongo los niños de manizales
     des pues de agregar uno, sigo agregando el siguiente mientras el temp no este vacio
     y finalmente me retorna la lista de niños de manizales y se repite el mismo proceso con los demas municipios
     **/
    public List<Boy> listBoyManizales (){
        Node temp = head;
        List<Boy> listBoyManizales = new ArrayList<>();
        temp = temp.getNext();
        while(temp.getNext() != null ){
            if(equals(Object.equals(temp.getData().getLocation(), "manizales"))){
                listBoyManizales.add(temp.getData());
            }
        }
        return  listBoyManizales;
    }

    /** pongo mi nodo temporal en la cabeza
     despues creo un arreglo donde pongo los niños de Neira
     des pues de agregar uno, sigo agregando el siguiente mientras el temp no este vacio
     y finalmente me retorna la lista de niños de neira y se repite el mismo proceso con los demas municipios
     **/
    public List<Boy> listBoyNeira (){
        Node temp = head;
        List<Boy> listBoyNeira = new ArrayList<>();
        temp = temp.getNext();
        while(temp.getNext() != null ){
            if(equals(Object.equals(temp.getData().getLocation(), "neira"))){
                listBoyNeira.add(temp.getData());
            }
        }
        return  listBoyNeira;

        /** pongo mi nodo temporal en la cabeza
         despues creo un arreglo donde pongo los niños de villamaria
         des pues de agregar uno, sigo agregando el siguiente mientras el temp no este vacio
         y finalmente me retorna la lista de niños de villamaria y se repite el mismo proceso con los demas municipios
         **/
        public List<Boy> listBoyVillamaria (){
            Node temp = head;
            List<Boy> listBoyVillamaria = new ArrayList<>();
            temp = temp.getNext();
            while(temp.getNext() != null ){
                if(equals(Object.equals(temp.getData().getLocation(), "villamaria"))){
                    listBoyVillamaria.add(temp.getData());
                }
            }
            return  listBoyVillamaria;

        //informe de los niños, segundo ejercicio
    //metodo que me permite saber que cantidad de RHS hay en cada grupo
            /** ubicamos el nodo temporal en la cabeza
             despues se inicializa una variable con un string en vacio
             int count = 0 -> Serà el total de veces que se recorre el ciclo while y dara el total que items que tiene la lista
             mientras el nodo temporal tenga algo
             se pregunta si el grado es igual al grado que estamos consultando y si el dato en el en el temp RH no es igual a null o no esta vacio
             si si, creamos una lista de RHS y agregamos el valor del RH de temp a la lista.
             si no, no agregamos nada y temp pasara al siguiente
             y finalmente se retorna la lista de los RHS con el contador**/
    public GradeByRH getGradeByRHByGrade(byte grade,String RH,int count);
        {
            Node temp = this.head;
            String RH = ""; int count=0;
            while (temp!=null)
            {
                if (temp.getData().getGrade()== grade);
                {
                    if (RH.contains(temp.getData().getRH()));
                    RH= RH+""+temp.getData().getRH();
                }
                count ++;
            }
            temp = temp.getNext();
        }
        return new GradeByRH(grade,RH,count);

    //este metodo es el que me permite llamar a cada grupo desde el 1 hasta el 5.
            /**validamos si la lita esta vacia
             le preguntamos al nodo temporal si la lista que tiene es igual a sl genero que estamos consultando
             si es asi, llamamos al otro metodo(gradebyRH), en la posicion i
             retornamos el genero consultado con los RHS por grado**/
    public GendersByGradeDTO getGenderByGradeDTOByGender(String gender,byte grade);
    {
        GradeByRH [] gradeByRHS = new GradeByRH [5];
        for (int i=0;i<5; i+1)
        {
            gradeByRHS[i] = getGenderByGradeDTOByGender((byte)(int));
        }
        return new GendersByGradeDTO(gender,gradeByRHS);
    }

    }

