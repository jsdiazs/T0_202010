package model.data_structures;

/**
 * 2019-01-23
 * Estructura de Datos Arreglo Dinamico de Strings.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * @author Fernando De la Rosa
 *
 */
public class ArregloDinamico<T extends Comparable<T>> implements IArregloDinamico<T>{
		/**
		 * Capacidad maxima del arreglo
		 */
        private int tamanoMax;
		/**
		 * Numero de elementos presentes en el arreglo (de forma compacta desde la posicion 0)
		 */
        private int tamanoAct;
        /**
         * Arreglo de elementos genericos de tamaNo maximo
         */
        private T elementos[ ];

        /**
         * Construir un arreglo con la capacidad maxima inicial.
         * @param max Capacidad maxima inicial
         */
		public ArregloDinamico( int max )
        {
            //elementos = new T[max]; ERROR//
        	elementos = (T[])new Object[max];
               tamanoMax = max;
               tamanoAct = 0;
        }

        //Agregamos solo elementos de tipo T//
		public void agregar( T dato )
        {
               if ( tamanoAct == tamanoMax )
               {  // caso de arreglo lleno (aumentar tamaNo)
                    tamanoMax = 2 * tamanoMax;
                    T [ ] copia = elementos;
                    elementos = (T[])new Object[tamanoMax];
                    for ( int i = 0; i < tamanoAct; i++)
                    {
                     	 elementos[i] = copia[i];
                    } 
            	    System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
               }	
               elementos[tamanoAct] = dato;
               tamanoAct++;
       }

		public int darCapacidad() {
			return tamanoMax;
		}

		public int darTamano() {
			return tamanoAct;
		}

		public T darElemento(int i) {
			return elementos[i];
		}

		public T buscar(T dato) {
			// TODO implementar
			T solucion =null;
			boolean encontro=false;
			for (int i=0; i<tamanoAct && !encontro; i++)
			{
				if(elementos[i].equals(dato))
				{
					encontro=true;
					solucion=elementos[i];

				}
			}
			// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.
			return solucion;
		}

		public boolean eliminar(T dato) {
			// TODO implementar
			// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings
			boolean encontro=false;
			if (buscar(dato) != null) {
				for(int j=0;j<tamanoAct && !encontro;j++)
				{
					if(elementos[j].equals(dato))
					{
						encontro=true;
						elementos[j]=null;
						System.out.println("Elemento borrado");
					}
				}
			}
			return encontro;
		}



}
