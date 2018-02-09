/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.ad.learning.tqtarademofx.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author alfonso
 */
@Entity
@Table(name = "apparecchiature")
@NamedQueries({
    @NamedQuery(name = Apparecchiature.FIND_ALL, 
            query = "SELECT a FROM Apparecchiature a order by a.codice")
})
public class Apparecchiature implements Serializable {

    public static final String FIND_ALL = "Apparecchiature.findAll";
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "codice")
    private String codice;
    @Column(name = "descrizione")
    private String descrizione;
    @Column(name = "laboratorio")
    private String laboratorio;
    @Column(name = "id_dominio")
    private Integer idDominio;
    @Column(name = "id_tipo")
    private Integer idTipo;
    @Column(name = "id_costruttore")
    private Integer idCostruttore;
    @Column(name = "id_distributore")
    private Integer idDistributore;
    @Column(name = "id_stato")
    private Integer idStato;
    @Column(name = "id_ubicazione")
    private Integer idUbicazione;
    @Column(name = "matricola_costruttore")
    private String matricolaCostruttore;

    @Column(name = "riferimento")
    private Character riferimento;

    @Column(name = "soggetta_a_manut")
    private Character soggettaAManut;

    @Column(name = "soggetta_a_taratura")
    private Character soggettaATaratura;
    @Column(name = "old_id")
    private Integer oldId;
    @Column(name = "centro_costo")
    private String centroCosto;
    @Column(name = "numero_parte")
    private String numeroParte;
    @Column(name = "numero_serie")
    private String numeroSerie;
    @Column(name = "marcatura")
    private String marcatura;
    @Column(name = "anno_costruzione")
    private String annoCostruzione;
    @Column(name = "programma")
    private String programma;
    @Column(name = "proprietario")
    private String proprietario;

    public Apparecchiature() {
    }

    public Apparecchiature(Integer id) {
        this.id = id;
    }

    public Apparecchiature(Integer id, String codice, Character riferimento, Character soggettaAManut, Character soggettaATaratura) {
        this.id = id;
        this.codice = codice;
        this.riferimento = riferimento;
        this.soggettaAManut = soggettaAManut;
        this.soggettaATaratura = soggettaATaratura;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public Integer getIdDominio() {
        return idDominio;
    }

    public void setIdDominio(Integer idDominio) {
        this.idDominio = idDominio;
    }

    public Integer getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public Integer getIdCostruttore() {
        return idCostruttore;
    }

    public void setIdCostruttore(Integer idCostruttore) {
        this.idCostruttore = idCostruttore;
    }

    public Integer getIdDistributore() {
        return idDistributore;
    }

    public void setIdDistributore(Integer idDistributore) {
        this.idDistributore = idDistributore;
    }

    public Integer getIdStato() {
        return idStato;
    }

    public void setIdStato(Integer idStato) {
        this.idStato = idStato;
    }

    public Integer getIdUbicazione() {
        return idUbicazione;
    }

    public void setIdUbicazione(Integer idUbicazione) {
        this.idUbicazione = idUbicazione;
    }

    public String getMatricolaCostruttore() {
        return matricolaCostruttore;
    }

    public void setMatricolaCostruttore(String matricolaCostruttore) {
        this.matricolaCostruttore = matricolaCostruttore;
    }

    public Character getRiferimento() {
        return riferimento;
    }

    public void setRiferimento(Character riferimento) {
        this.riferimento = riferimento;
    }

    public Character getSoggettaAManut() {
        return soggettaAManut;
    }

    public void setSoggettaAManut(Character soggettaAManut) {
        this.soggettaAManut = soggettaAManut;
    }

    public Character getSoggettaATaratura() {
        return soggettaATaratura;
    }

    public void setSoggettaATaratura(Character soggettaATaratura) {
        this.soggettaATaratura = soggettaATaratura;
    }

    public Integer getOldId() {
        return oldId;
    }

    public void setOldId(Integer oldId) {
        this.oldId = oldId;
    }

    public String getCentroCosto() {
        return centroCosto;
    }

    public void setCentroCosto(String centroCosto) {
        this.centroCosto = centroCosto;
    }

    public String getNumeroParte() {
        return numeroParte;
    }

    public void setNumeroParte(String numeroParte) {
        this.numeroParte = numeroParte;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getMarcatura() {
        return marcatura;
    }

    public void setMarcatura(String marcatura) {
        this.marcatura = marcatura;
    }

    public String getAnnoCostruzione() {
        return annoCostruzione;
    }

    public void setAnnoCostruzione(String annoCostruzione) {
        this.annoCostruzione = annoCostruzione;
    }

    public String getProgramma() {
        return programma;
    }

    public void setProgramma(String programma) {
        this.programma = programma;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Apparecchiature)) {
            return false;
        }
        Apparecchiature other = (Apparecchiature) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.ad.learning.tqtarademofx.entity.Apparecchiature[ id=" + id + " ]";
    }
    
}
