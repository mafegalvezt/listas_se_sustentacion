package com.umanizales.lists_prog2.model.listase;
/**
 * Clase que me permite gestionar una lista simplemente enlazada
 * contiene los métodos u operaciones ....
 * solo cuenta con los atributo head = que representa el primer niño
 * ...
 */


import com.umanizales.lists_prog2.exception.ListaSeException;
import com.umanizales.lists_prog2.model.Boy;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ListSE<count> {
    /**
     * Atributo que representa el inicio de la lista y es
     */
    private Node head;
    private int count;

    /**
     * Método que adiciona un niño al final de la lista
     * @param boy
     * @throws ListaSeException
     */
    public void add(Boy boy) throws ListaSeException
    {
        /**
         * Se invoca el método encontrar por identificación, para verificar si
         * el niño que está ingresando ya existe
         */
        Boy boyExist= findByIdentification(boy.getIdentification());
        if(boyExist !=null)
        {
            /**
             * Si el niño ya existe se lanza la excepeción para comunicar al usuario en el controller
             */
            throw  new ListaSeException("La identificación ingresada ya existe");
        }

        //si la cabeza esta vacia
        if(head == null)
        {
            //agregamos un niño y se lo asigna a la cabeza
            head = new Node(boy);
        }
        else
        {
            //llamo a un ayudante para que se pare en la cabeza
            Node temp = head;
            //mientras haya algo
            while(temp.getNext()!=null)
            {
                //se pasa al siguiente
                temp = temp.getNext();
            }
            ///se pasa de uno en uno hasta quedar parado en el ultimo porque ahi se adiciona el siguiente
            temp.setNext(new Node(boy));
        }
        count++;
    }


    //metodo para adicionar niños al inicio
    public void addToStart(Boy boy) throws ListaSeException
    {
        //se invoca al identificador para saber si el que vamos a agregar ya existe
        Boy boyExist= findByIdentification(boy.getIdentification());
        if(boyExist !=null)
        {
           //si el niño que vamos a agregar ya existe entonces se le comunica al usuario
            throw  new ListaSeException("La identificación ingresada ya existe");
        }
        if( this.head==null)
        {
            this.head = new Node(boy);
        }
        else
        {
            Node temp = new Node(boy);
            temp.setNext(this.head);
            this.head= temp;
        }
        count++;
    }

    //adicionar niños en la posición que deseemos
    public void addByPosition(Boy boy, int position) throws ListaSeException
    {
        //se verifica si el niño que vamos a agragar ya existe validando la identificacion
        Boy boyExist= findByIdentification(boy.getIdentification());
        if(boyExist !=null)
        {
            //si ya existe se le muestra al usuario un mensaje
            throw  new ListaSeException("La identificación ingresada ya existe");
        }
        /// Validación de la posicíon
        if(position > count)
        {
            this.add(boy);
            return;
            //throw  new ListaSeException("La posición ingresada no es válida");
        }
        if(position ==1)
        {
            addToStart(boy);
        }
        else
        {
            int cont=1;
            Node temp = this.head;
            while(temp!=null)
            {
                if(cont == position-1 )
                {
                    break;
                }
                temp= temp.getNext();
                cont++;
            }
            //Ayudante va estar posicionado en la posición anterior
            Node nodeNew= new Node(boy);
            nodeNew.setNext(temp.getNext());
            temp.setNext(nodeNew);
            count++;
        }
    }

    //metodo de invertir
    public void invert() throws ListaSeException{
        //si la cabeza es diferente de null
        if (this.head != null) {
            ListSE listTemp = new ListSE();
            //recorrer la lista de principio a fin llamando al ayudante
            //usar this es una buena practica para asegurarme de que me estoy refiriendo a mi atributo de instancia
            Node temp = this.head;
            //mientras tempotal sea diferente de null
            while(temp != null)
            {
                //se adiciona a la nueva lista
                listTemp.addToStart(temp.getData());
                //pasa al siguiente y como queda null o llega al ultimo se sale
                temp = temp.getNext();

            }
            this.head = listTemp.getHead();
        }


    }
    //cuenta cuantos niños tengo
    public int count() {
        int count = 0;
        //se para en la cabeza
        if (this.head != null) {
            Node temp = this.head;
            while (temp != null)
            {
                count++;
                temp = temp.getNext();
            }
        }
        return count;
    }


    //metodo empleado para listar los niños
    public List<Boy> list() throws ListaSeException
    {
        if(this.head!=null)
        {
            Node temp = this.head;
            List<Boy> list= new ArrayList<>();
            while (temp != null)
            {
                list.add(temp.getData());
                temp = temp.getNext();
            }
            return list;
        }
        throw  new ListaSeException("No hay datos en la lista");
        //return null;

    }

    //metodo para cambiar los extremos
    public void changeXtremes() throws  ListaSeException{
        if (this.head != null && this.head.getNext() != null) {
            Boy start = this.head.getData();
            Node temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            this.head.setData(temp.getData());
            temp.setData(start);

        }
        else
        {
            throw  new ListaSeException("NO es posible ejecutar el cambio de extremos");
        }


    }


    public void delete(String identification) throws ListaSeException
    {
        if(this.head!=null)
        {
            if(this.head.getData().getIdentification().equals(identification))
            {
                this.head = this.head.getNext();
            }
            else
            {
                Node temp = this.head;
                while(temp!=null)
                {
                    if(temp.getNext() != null &&
                            temp.getNext().getData().getIdentification().equals(identification))
                    {
                        break;
                    }
                    temp= temp.getNext();
                }
                //Temp va estar parado en el anterior al que debo eliminar o va a ser null
                if(temp!= null)
                {
                    temp.setNext(temp.getNext().getNext());
                }
                else
                {
                    throw  new ListaSeException("La identificación "+identification + " no existe en la lista");
                }
            }
        }
        else
        {
            throw  new ListaSeException("NO hay datos en la lista");
        }
    }

    /**
     * Método que me busca en la lista simplemente enlazada, un niño a partir de la identificación
     * Si no encuentra el niño retorna vacío (null)
     * @param identification Cédula, TI, CE , Sisben que identifica el niño que voy a buscar
     * @return El niño que encontré con todos sus datos
     */
    public Boy findByIdentification(String identification) {
        /**
         * Cómo no me puedo mover de la cabeza por que s eme vuelan todos los niños,
         * LLamo a un ayudante y lo ubico en la cabeza o inicio
         */
        Node temp= this.head;
        /**
         * Creo un ciclo para recorrer la lista SE de principio a fin
         * llego al final cuando mi ayudante queda para en vacío (null)
         */
        while(temp!=null)
        {
            /**
             * Pregunto si el niño en el cual está ubicado mi ayudante es el de la identificación
             * que estoy buscando ingresado en el parámetro identificacion
             */
            if(temp.getData().getIdentification().equals(identification))
            {
                /**
                 * Lo encontré y lo retorno de inmediato
                 * Finaliza mi método
                 */
                return temp.getData();
            }
            /**
             * Mi ayudante se pasa al siguiente nodo
             */
            temp=temp.getNext();
        }
        /**
         * Si llega a esta línea significa que no encontré el niño y retorno vacío
         */
       return null;
    }

    public void validateListEmpty() throws ListaSeException
    {
        if(this.head==null)
        {
            throw new ListaSeException("No hay datos en la lista");
        }
    }

    public ListSE getListSeBoysByGender(String gender) throws ListaSeException
    {
        validateListEmpty();
        Node temp= this.head;
        ListSE listTemp = new ListSE();
        while(temp !=null)
        {
            if(temp.getData().getGender().name().equals(gender))
            {
                listTemp.add(temp.getData());
            }
            temp = temp.getNext();
        }
        return listTemp;
    }

    public void variantBoys() throws ListaSeException
    {
        validateListEmpty();
        ListSE kids= this.getListSeBoysByGender("MASCULINO");
        ListSE girls= this.getListSeBoysByGender("FEMENINO");
        ListSE minList= null;
        ListSE maxList= null;
        if(kids.getCount()> girls.getCount())
        {
            minList= girls;
            maxList = kids;
        }
        else
        {
            minList = kids;
            maxList = girls;
        }
        Node temp= minList.getHead();
        int pos=2;
        while(temp != null)
        {
            maxList.addByPosition(temp.getData(), pos);
            pos = pos +2;
            temp = temp.getNext();
        }
        this.head= maxList.getHead();

    }


    ///Método que recibe el código de una ciudad y retorna la cantidad de niños
    /**public int getCountBoysByLocation(String code) throws ListaSeException {
        Node temp= this.getHead();
            int count=0;
            while(temp != null)
            {
              public void variantBoys() throws ListaSeException
                {
                    validateListEmpty();
                    ListSE kids= this.getListSeBoysByGender("MASCULINO");
                    ListSE girls= this.getListSeBoysByGender("FEMENINO");
                    ListSE minList= null;
                    ListSE maxList= null;
                    if(kids.getCount()> girls.getCount())
                    {
                        minList= girls;
                        maxList = kids;
                    }
                    else
                    {
                        minList = kids;
                        maxList = girls;
                    }
                    temp = minList.getHead();
                    int pos=2;
                    while(temp != null)
                    {
                        maxList.addByPosition(temp.getData(), pos);
                        pos = pos +2;
                        temp = temp.getNext();
                    }
                    this.head= maxList.getHead();

                }**/

                ///Método que recibe el código de una ciudad y retorna la cantidad de niños
                /**public int getCountBoysByLocation(String code)
                {
                    temp = this.getHead();
                    count = 0;
                    while(temp != null)
                    {
                        if(temp.getData().getLocation().getCode().equals(code))
                        {
                            count++;
                        }
                        temp = temp.getNext();
                    }
                    return count;

                }

            }
                if(temp.getData().getLocation().getCode().equals(code))
                {
                    count++;
                }
                temp = temp.getNext();
            }
            return count;

    }

    public int age (String age)**/



}

