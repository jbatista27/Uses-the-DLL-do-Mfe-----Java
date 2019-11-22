package Mfe;
import com.sun.jna.Library;
import com.sun.jna.Native;

public class Call_mfe {
	public interface Itf_mfe extends Library{
		public String AtivarSAT(int iNumSessao, int iSubCmd, String pcCodAtivacao, String pcCnpj, int iUF);
		public String ComunicarCertificadoICPBRASIL(int iNumSessao, String pcCodAtivacao, String pcCertificado);
		public String EnviarDadosVenda(int iNumSessao, String pcCodAtivacao, String pcDadosVenda);
		public String CancelarUltimaVenda(int iNumSessao, String pcCodAtivacao, String pcChaveCfe, String pcDadosCanc);
		public String ConsultarSAT(int iNumSessao);
		public String TesteFimAFim(int iNumSessao, String pcCodAtivacao, String pcDadosVenda);
		public String ConsultarStatusOperacional(int iNumSessao, String pcCodAtivacao);
		public String ConsultarNumeroSessao(int iNumSessao, String pcCodAtivacao, int luiNumSessaoConsultada); 
		public String ConfigurarInterfaceDeRede(int iNumSessao, String pcCodAtivacao, String pcDadosConfiguracao);
		public String AssociarAssinatura(int iNumSessao, String pcCodAtivacao, String pcCnpj, String lpcAssinaturaCnpjs);
		public String AtualizarSoftwareSAT(int iNumSessao, String pcCodAtivacao);
		public String ExtrairLogs(int iNumSessao, String pcCodAtivacao);
		public String BloquearSAT(int iNumSessao, String pcCodAtivacao);
		public String DesbloquearSAT(int iNumSessao, String pcCodAtivacao);
		public String TrocarCodigoDeAtivacao(int iNumSessao,String pcCodAtivacao,int iOpcao, String pcNovoCod, String pcConfirmaNovoCod);
		public String ConsultarStatusOperacionalMFE(int iNumSessao, String pcCodAtivacao);
		public String ConfigurarInterfaceDeRedeMFE(int iNumSessao, String pcCodAtivacao, String pcDadosConfiguracao);
		public String EnviarStatusAC(int iNumSessao, String pcCodAtivacao, String pcFabricante, String pcVersaoAC);
	}
	
	public String ativarSAT(int iv_NumSessao, int iv_SubCmd, String iv_pcCodAtivacao, String iv_pcCnpj, int iv_UF, String iv_directory){
		System.setProperty ("jna.encoding", "windows-1252");
		
		@SuppressWarnings("deprecation")
		Call_mfe.Itf_mfe loMfe = (Call_mfe.Itf_mfe) Native.loadLibrary(iv_directory, Call_mfe.Itf_mfe.class);
		
		try {
			String evReturnAtivaSat = loMfe.AtivarSAT(iv_NumSessao, iv_SubCmd, iv_pcCodAtivacao, iv_pcCnpj, iv_UF);	
			String evReturn         = new String(evReturnAtivaSat.getBytes(), "UTF-8");
			return evReturn;
		}catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public String comunicarCertificadoICPBRASIL(int iv_NumSessao, String iv_pcCodAtivacao, String iv_pcCertificado, String iv_directory){
		System.setProperty ("jna.encoding", "windows-1252");
		
		@SuppressWarnings("deprecation")
		Call_mfe.Itf_mfe loMfe = (Call_mfe.Itf_mfe) Native.loadLibrary(iv_directory, Call_mfe.Itf_mfe.class);
		
		try {
			
			String evReturnIcpBra = loMfe.ComunicarCertificadoICPBRASIL(iv_NumSessao, iv_pcCodAtivacao, iv_pcCertificado);
			String evReturn       = new String(evReturnIcpBra.getBytes(), "UTF-8");
			return evReturn;
		}catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public String enviarDadosVenda(int iv_NumSessao, String iv_pcCodAtivacao, String iv_pcDadosVenda, String iv_directory){
		System.setProperty ("jna.encoding", "windows-1252");
		
		@SuppressWarnings("deprecation")
		Call_mfe.Itf_mfe loMfe = (Call_mfe.Itf_mfe) Native.loadLibrary(iv_directory, Call_mfe.Itf_mfe.class);
		
		try {
			
			String pcDadosVendaMod    = iv_pcDadosVenda.replaceAll("&lt;", "<");  //Troca de caracteres
			String pcDadosVenda       = pcDadosVendaMod.replaceAll("&gt;", ">"); //Troca de caracteres
			String evReturnDadosVenda = loMfe.EnviarDadosVenda(iv_NumSessao, iv_pcCodAtivacao, pcDadosVenda);	
			String evReturn           = new String(evReturnDadosVenda.getBytes(), "UTF-8");
			
			return evReturn;
		}catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public String cancelarUltimaVenda(int iv_NumSessao, String iv_pcCodAtivacao, String iv_pcChaveCfe, String iv_pcDadosCanc, String iv_directory){
		System.setProperty ("jna.encoding", "windows-1252");
		
		@SuppressWarnings("deprecation")
		Call_mfe.Itf_mfe loMfe = (Call_mfe.Itf_mfe) Native.loadLibrary(iv_directory, Call_mfe.Itf_mfe.class);
		
		try {
			
			String pcDadosCancMod      = iv_pcDadosCanc.replaceAll("&lt;", "<"); //Troca de caracteres
			String pcDadosCanc         = pcDadosCancMod.replaceAll("&gt;", ">"); //Troca de caracteres
			String evReturnCancUltVend = loMfe.CancelarUltimaVenda(iv_NumSessao, iv_pcCodAtivacao, iv_pcChaveCfe, pcDadosCanc);	 
			String evReturn            = new String(evReturnCancUltVend.getBytes(), "UTF-8");
			
			return evReturn;
		}catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public String consultarSAT(int iv_NumSessao, String iv_directory){
		System.setProperty ("jna.encoding", "windows-1252");
		
		@SuppressWarnings("deprecation")
		Call_mfe.Itf_mfe loMfe = (Call_mfe.Itf_mfe) Native.loadLibrary(iv_directory, Call_mfe.Itf_mfe.class);
		
		try {
			
			String returnSat = loMfe.ConsultarSAT(iv_NumSessao);	 
			String evReturn  = new String(returnSat.getBytes(), "UTF-8");
			
			return evReturn;
		}catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public String testeFimAFim(int iv_NumSessao, String iv_pcCodAtivacao, String iv_pcDadosVenda, String iv_directory){
		System.setProperty ("jna.encoding", "windows-1252");
		
		@SuppressWarnings("deprecation")
		Call_mfe.Itf_mfe loMfe = (Call_mfe.Itf_mfe) Native.loadLibrary(iv_directory, Call_mfe.Itf_mfe.class);
		
		try {
			
			String pcDadosVendaMod = iv_pcDadosVenda.replaceAll("&lt;", "<");
			String pcDadosVenda    = pcDadosVendaMod.replaceAll("&gt;", ">");
			String evReturnFimAFim = loMfe.TesteFimAFim(iv_NumSessao, iv_pcCodAtivacao, pcDadosVenda);	 
			String evReturn        = new String(evReturnFimAFim.getBytes(), "UTF-8");
			
			return evReturn;
		}catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public String consultarStatusOperacional(int iv_NumSessao, String iv_pcCodAtivacao, String iv_directory){
		System.setProperty ("jna.encoding", "windows-1252");
		
		@SuppressWarnings("deprecation")
		Call_mfe.Itf_mfe loMfe = (Call_mfe.Itf_mfe) Native.loadLibrary(iv_directory, Call_mfe.Itf_mfe.class);
		
		try {
			
			String evReturnConsStaOpe = loMfe.ConsultarStatusOperacional(iv_NumSessao, iv_pcCodAtivacao);
			String evReturn           = new String(evReturnConsStaOpe.getBytes(), "UTF-8");
			
			return evReturn;
		}catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public String consultarStatusOperacionalMFE(int iv_NumSessao, String iv_pcCodAtivacao, String iv_directory){
		System.setProperty ("jna.encoding", "windows-1252");
		
		@SuppressWarnings("deprecation")
		Call_mfe.Itf_mfe loMfe = (Call_mfe.Itf_mfe) Native.loadLibrary(iv_directory, Call_mfe.Itf_mfe.class);
		
		try {
			
			String evReturnConStaOpeMfe = loMfe.ConsultarStatusOperacionalMFE(iv_NumSessao, iv_pcCodAtivacao);
			String evReturn             = new String(evReturnConStaOpeMfe.getBytes(), "UTF-8");
			
			return evReturn;
		}catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public String consultarNumeroSessao(int iv_NumSessao, String iv_pcCodAtivacao, int iv_luiNumSessaoConsultada, String iv_directory){
		System.setProperty ("jna.encoding", "windows-1252");
		
		@SuppressWarnings("deprecation")
		Call_mfe.Itf_mfe loMfe = (Call_mfe.Itf_mfe) Native.loadLibrary(iv_directory, Call_mfe.Itf_mfe.class);
		
		try {
			
			String evReturnConsNumSessao = loMfe.ConsultarNumeroSessao(iv_NumSessao, iv_pcCodAtivacao, iv_luiNumSessaoConsultada);
			String evReturn              = new String(evReturnConsNumSessao.getBytes(), "UTF-8");
			
			return evReturn;
		}catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public String configurarInterfaceDeRede(int iv_iNumSessao, String iv_pcCodAtivacao, String iv_pcDadosConfiguracao, String iv_directory){
		System.setProperty ("jna.encoding", "windows-1252");
		
		@SuppressWarnings("deprecation")
		Call_mfe.Itf_mfe loMfe = (Call_mfe.Itf_mfe) Native.loadLibrary(iv_directory, Call_mfe.Itf_mfe.class);
		
		try {
			
			String evReturnConfigIntRede = loMfe.ConfigurarInterfaceDeRede(iv_iNumSessao, iv_pcCodAtivacao, iv_pcDadosConfiguracao);	
			String evReturn              = new String(evReturnConfigIntRede.getBytes(), "UTF-8");
			
			return evReturn;
		}catch (Exception e) {
			return e.getMessage();
		}
	}

	public String extrairLogs(int iv_NumSessao, String iv_pcCodAtivacao, String iv_directory){
		System.setProperty ("jna.encoding", "windows-1252");
		
		@SuppressWarnings("deprecation")
		Call_mfe.Itf_mfe loMfe = (Call_mfe.Itf_mfe) Native.loadLibrary(iv_directory, Call_mfe.Itf_mfe.class);
		
		try {
			
			String evReturnExtraLogs = loMfe.ExtrairLogs(iv_NumSessao, iv_pcCodAtivacao);
			String evReturn          = new String(evReturnExtraLogs.getBytes(), "UTF-8");
			
			return evReturn;
		}catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public String bloquearSAT(int iv_NumSessao, String iv_pcCodAtivacao,String iv_directory){
		System.setProperty ("jna.encoding", "windows-1252");
		
		@SuppressWarnings("deprecation")
		Call_mfe.Itf_mfe loMfe = (Call_mfe.Itf_mfe) Native.loadLibrary(iv_directory, Call_mfe.Itf_mfe.class);
		
		try {
			
			String evReturnBloqSat = loMfe.BloquearSAT(iv_NumSessao, iv_pcCodAtivacao);	 
			String evReturn        = new String(evReturnBloqSat.getBytes(), "UTF-8");
			
			return evReturn;
		}catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public String desbloquearSAT(int iv_NumSessao, String iv_pcCodAtivacao, String iv_directory){
		System.setProperty ("jna.encoding", "windows-1252");
		
		@SuppressWarnings("deprecation")
		Call_mfe.Itf_mfe loMfe = (Call_mfe.Itf_mfe) Native.loadLibrary(iv_directory, Call_mfe.Itf_mfe.class);
		
		try {
			
			String evReturnDesbloSat = loMfe.DesbloquearSAT(iv_NumSessao, iv_pcCodAtivacao);	 
			String evReturn          = new String(evReturnDesbloSat.getBytes(), "UTF-8");
			
			return evReturn;
		}catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public String trocarCodigoDeAtivacao(int iv_NumSessao,String iv_pcCodAtivacao,int iv_Opcao, String iv_pcNovoCod, String iv_pcConfirmaNovoCod, String iv_directory){
		System.setProperty ("jna.encoding", "windows-1252");
		
		@SuppressWarnings("deprecation")
		Call_mfe.Itf_mfe loMfe = (Call_mfe.Itf_mfe) Native.loadLibrary(iv_directory, Call_mfe.Itf_mfe.class);
		
		try {
			
			String evReturnTrocaCodAtiv = loMfe.TrocarCodigoDeAtivacao(iv_NumSessao, iv_pcCodAtivacao, iv_Opcao, iv_pcNovoCod, iv_pcConfirmaNovoCod);	 
			String evReturn             = new String(evReturnTrocaCodAtiv.getBytes(), "UTF-8");
			
			return evReturn;
		}catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public String configurarInterfaceDeRedeMFE(int iv_iNumSessao, String iv_pcCodAtivacao, String iv_pcDadosConfiguracao, String iv_directory){
		System.setProperty ("jna.encoding", "windows-1252");
		
		@SuppressWarnings("deprecation")
		Call_mfe.Itf_mfe loMfe = (Call_mfe.Itf_mfe) Native.loadLibrary(iv_directory, Call_mfe.Itf_mfe.class);
		
		try {
			
			String evReturnConfIntRedMfe = loMfe.ConfigurarInterfaceDeRedeMFE(iv_iNumSessao, iv_pcCodAtivacao, iv_pcDadosConfiguracao);	 
			String evReturn              = new String(evReturnConfIntRedMfe.getBytes(), "UTF-8");
			
			return evReturn;
		}catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public String enviarStatusAC(int iv_NumSessao, String iv_pcCodAtivacao, String iv_pcFabricante, String iv_pcVersaoAC, String iv_directory){
		System.setProperty ("jna.encoding", "windows-1252");
		
		@SuppressWarnings("deprecation")
		Call_mfe.Itf_mfe loMfe = (Call_mfe.Itf_mfe) Native.loadLibrary(iv_directory, Call_mfe.Itf_mfe.class);
		
		try {
			
			String evReturnEnvStatAc = loMfe.EnviarStatusAC(iv_NumSessao, iv_pcCodAtivacao, iv_pcFabricante, iv_pcVersaoAC);
			String evReturn          = new String(evReturnEnvStatAc.getBytes(), "UTF-8");
			
			return evReturn;
		}catch (Exception e) {
			return e.getMessage();
		}
	}
}
