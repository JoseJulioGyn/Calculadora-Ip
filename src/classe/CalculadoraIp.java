package classe;

public class CalculadoraIp {

	private int octeto1;
	private int octeto2;
	private int octeto3;
	private int octeto4;
	private int mascara;
	private static int[] tabela = { 128, 64, 32, 16, 8, 4, 2, 1 };

        public void setOcteto1(int octeto1) {
            this.octeto1 = octeto1;
        }
        
        public void setOcteto2(int octeto2) {
            this.octeto2 = octeto2;
        }
        
        public void setOcteto3(int octeto3) {
            this.octeto3 = octeto3;
        }
        
        public void setOcteto4(int octeto4) {
            this.octeto4 = octeto4;
        }

        public void setMascara(int mascara) {
            this.mascara = mascara;
        }
          
	public String calcularIP() {
		int aux;
		int hots;
		int auxHots;
		int rede = 0;
		int broadcast;
		int novaMascara = 0;
		String saida = "";
		int totalIps = 0;

		if ((mascara >= 0) && (mascara <= 7)) {
			aux = 8 - mascara;
			hots = (int) (Math.pow(2, aux)) - 1;

			auxHots = hots;
			broadcast = hots;

			for (int x = 1; x <= auxHots; x++) {

				if (octeto1 == x) {
					break;
				}

				if (x == auxHots) {
					if (auxHots < 255) {
						rede = auxHots + 1;
						auxHots = auxHots + hots + 1;
						broadcast = auxHots;
					}
				}
			}

			for (int x = 0; x < mascara; x++) {
				novaMascara += tabela[x];
			}

			totalIps = (int) Math.pow(2, (aux + 24));

			saida = " IP: " + octeto1 + "." + octeto2 + "." + octeto3 + "."+ octeto4 + "/" + mascara;
			saida += "\n Mascara: " + novaMascara + "." + "0.0.0";
			saida += "\n Rede: " + rede + ".0.0.0";
			saida += "\n BroadCast: " + broadcast + ".255.255.255";
			saida += "\n Range: " + rede + ".0.0.0  a  " + broadcast+ ".255.255.255";
			saida += "\n Primeiro Ip: " + rede + ".0.0.1";
			saida += "\n Ultimo Ip: " + broadcast + ".255.255.254";
			saida += "\n Total de IPs : " + totalIps;
			saida += "\n Total de IPs para uso: " + (totalIps - 2);

		} else if ((mascara >= 8) && (mascara <= 16)) {
			aux = 16 - mascara;
			hots = (int) (Math.pow(2, aux)) - 1;

			auxHots = hots;
			broadcast = hots;

			for (int x = 1; x <= auxHots; x++) {

				if (octeto2 == x) {
					break;
				}

				if (x == auxHots) {
					if (auxHots < 255) {
						rede = auxHots + 1;
						auxHots = auxHots + hots + 1;
						broadcast = auxHots;
					}
				}
			}

			for (int x = 0; x < (8 - aux); x++) {
				novaMascara += tabela[x];
			}

			if (mascara == 8) {
				totalIps = (int) Math.pow(2, 24);
			} else {
				totalIps = (int) Math.pow(2, (aux + 16));
			}

			saida = " IP: " + octeto1 + "." + octeto2 + "." + octeto3 + "."+ octeto4 + "/" + mascara;

			if (mascara == 8) {
				saida += "\n Mascara: 255.0.0.0";
			} else {
				saida += "\n Mascara: 255." + novaMascara + ".0.0";
			}

			saida += "\n Rede: " + octeto1 + "." + rede + ".0.0";
			saida += "\n BroadCast: " + octeto1 + "." + broadcast + ".255.255";
			saida += "\n Range: " + octeto1 + "." + rede + ".0.0  a  "+ octeto1 + "." + broadcast + ".255.255";
			saida += "\n Primeiro Ip: " + octeto1 + "." + rede + ".0.1";
			saida += "\n Ultimo Ip: " + octeto1 + "." + broadcast + ".255.254";
			saida += "\n Total de IPs : " + totalIps;
			saida += "\n Total de IPs para uso: " + (totalIps - 2);

		} else if ((mascara >= 17) && (mascara <= 23)) {
			aux = 24 - mascara;
			hots = (int) (Math.pow(2, aux)) - 1;

			auxHots = hots;
			broadcast = hots;

			for (int x = 1; x <= auxHots; x++) {

				if (octeto3 == x) {
					break;
				}

				if (x == auxHots) {
					if (auxHots < 255) {
						rede = auxHots + 1;
						auxHots = auxHots + hots + 1;
						broadcast = auxHots;
					}
				}
			}

			for (int x = 0; x < (8 - aux); x++) {
				novaMascara += tabela[x];
			}

			if (mascara == 16) {
				totalIps = (int) Math.pow(2, 16);
			} else {
				totalIps = (int) Math.pow(2, (aux + 8));
			}

			saida = " IP: " + octeto1 + "." + octeto2 + "." + octeto3 + "."+ octeto4 + "/" + mascara;

			if (mascara == 16) {
				saida += "\n Mascara: 255.255.0.0";
			} else {
				saida += "\n Mascara: 255.255." + novaMascara + ".0";
			}

			saida += "\n Rede: " + octeto1 + "." + octeto2 + "." + rede + ".0";
			saida += "\n BroadCast: " + octeto1 + "." + octeto2 + "."+ broadcast + ".255";
			saida += "\n Range: " + octeto1 + "." + octeto2 + "." + rede+ ".0  a  " + octeto1 + "." + octeto2 + "." + broadcast+ ".255";
			saida += "\n Primeiro Ip: " + octeto1 + "." + octeto2 + "." + rede+ ".1";
			saida += "\n Ultimo Ip: " + octeto1 + "." + octeto2 + "."+ broadcast + ".254";
			saida += "\n Total de IPs : " + totalIps;
			saida += "\n Total de IPs para uso: " + (totalIps - 2);

		} else if ((mascara >= 24) && (mascara <= 31)) {
			aux = 32 - mascara;
			hots = (int) (Math.pow(2, aux)) - 1;

			auxHots = hots;
			broadcast = hots;

			for (int x = 1; x <= auxHots; x++) {

				if (octeto4 == x) {
					break;
				}

				if (x == auxHots) {
					if (auxHots < 255) {
						rede = auxHots + 1;
						auxHots = auxHots + hots + 1;
						broadcast = auxHots;
					}
				}
			}

			for (int x = 0; x < (8 - aux); x++) {
				novaMascara += tabela[x];
			}

			if (mascara == 24) {
				totalIps = (int) Math.pow(2, 8);
			} else {
				totalIps = (int) Math.pow(2, aux);
			}

			saida = " IP: " + octeto1 + "." + octeto2 + "." + octeto3 + "."+ octeto4 + "/" + mascara;

			if (mascara == 24) {
				saida += "\n Mascara: 255.255.255.0";
			} else {
				saida += "\n Mascara: 255.255.255." + novaMascara;
			}
			saida += "\n Rede: " + octeto1 + "." + octeto2 + "." + octeto3+ "." + rede;
			saida += "\n BroadCast: " + octeto1 + "." + octeto2 + "." + octeto3+ "." + broadcast;
			saida += "\n Range: " + octeto1 + "." + octeto2 + "." + octeto3+ "." + rede + "  a  " + octeto1 + "." + octeto2 + "."+ octeto3 + "." + broadcast;

			if (mascara == 31) {
			} else {
				saida += "\n Primeiro Ip: " + octeto1 + "." + octeto2 + "."+ octeto3 + "." + (rede + 1);
				saida += "\n Ultimo Ip: " + octeto1 + "." + octeto2 + "."+ octeto3 + "." + (broadcast - 1);
			}

			saida += "\n Total de IPs : " + totalIps;
			saida += "\n Total de IPs para uso: " + (totalIps - 2);
		}else{
                    saida = "Nao foi possivel calcular IP";
                }

		return saida;
	}
}