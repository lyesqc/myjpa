package com.yourcompany.struts.form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Recep implements Serializable
	{
	   private String article = null;
	   private String ND = null ;
	   private String NF = null ;
	   private String profil = null ;
	   private String qte = null ;
	   private String sup;
	   private String test;
	   private String num_ligne;
	   
	 
	   
	   private String aaa = null;
	   private String ppp = null;
	   private String stt = null;
	   private String see = null;
	   private String qtt = null;
	   
	   List nomArticle= new ArrayList() ;
		List nomProfil= new ArrayList() ;
	 
	   public Recep()
	   {
	      this.article=article ;
	      this.ND=ND ;
	      this.NF=NF;
	      this.profil=profil ;
	      this.qte=qte ;
	      this.sup=sup;
	      this.test=test;
	    }
	 
	   // getters et setters sur 
	   
	   
	   public String getTest() {
			return test;
			}
		 
			
		public void setTest(String test) {
		            this.test = test;
			}
	   
	   
	   public String getQte() {
			return qte;
			}
		 
			
		public void setQte(String qte) {
		            this.qte = qte;
			}
	   
	   
	   public String getArticle() {
			return article;
			}
		 
			
		public void setArticle(String article) {
		            this.article = article;
			}

		
		public String getProfil() {
			return profil;
			}
		 
			
		public void setProfil(String profil) {
		            this.profil = profil;
			}


		 public String getND() {
				return ND;
				}
			 
				
			public void setND(String ND) {
			            this.ND = ND;
				}
		

			 public String getNF() {
					return NF;
					}
				 
					
				public void setNF(String NF) {
				            this.NF = NF;
					
				            
			
}
				
				public List getNomArticle() {
					return nomArticle;
				}	
				
				public void setNomArticle(List nomArticle) {
					this.nomArticle = nomArticle;
				}	
				
				public List getNomProfil() {
					return nomProfil;
				}	
				
				public void setNomProfil(List nomProfil) {
					this.nomProfil = nomProfil;
				}	
				
				
				public String getSup() {
					return sup;
					}
				 
					
				public void setSup(String sup) {
				            this.sup = sup;
				
				            
			
}
				
				
				 public String getAaa() {
						return aaa;
						}
					 
						
					public void setAaa(String aaa) {
					            this.aaa = aaa;
						}
					 public String getPpp() {
							return ppp;
							}
						 
							
						public void setPpp(String ppp) {
						            this.ppp = ppp;
							}
						
						 public String getStt() {
								return stt;
								}
							 
								
							public void setStt(String stt) {
							            this.stt = stt;
								}
							
							
							 public String getSee() {
									return see;
									}
								 
									
								public void setSee(String see) {
								            this.see = see;
									}
								
								 public String getQtt() {
										return qtt;
										}
									 
										
									public void setQtt(String qtt) {
									            this.qtt = qtt;
										}

									public String getNum_ligne() {
										return num_ligne;
									}

									public void setNum_ligne(String num_ligne) {
										this.num_ligne = num_ligne;
									}
	}



