package org.ryh.baptis.service;

import org.jrebirth.af.api.wave.Wave;
import org.jrebirth.af.core.service.DefaultService;
import org.ryh.baptis.beans.Databaptis;

import java.io.IOException;
import java.util.Date;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.jrebirth.af.api.annotation.PriorityLevel;
import org.jrebirth.af.api.concurrent.Priority;
import org.jrebirth.af.api.module.Register;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

@Register(value = SearchService.class, priority = PriorityLevel.High)
public class SearchServiceImpl extends DefaultService implements SearchService{
	
	private ObservableList<Databaptis> searchResults;

    @Override
    public void initService() {
        listen(DO_SEARCHING);
    }

    @Override
    @Priority(PriorityLevel.High)
    public void doSearching(final String value, final Wave wave) throws ParseException, IOException, InterruptedException {
        Thread.sleep(2000);
        
        final IndexServiceImpl indexService = getService(IndexServiceImpl.class);
        
        StandardAnalyzer analyzer = indexService.getAnalyzer();
        Directory index = indexService.getIndex();

        String querystr = "NAMA : "+value;
        Query q = new QueryParser("NAMA", analyzer).parse(querystr);
        int hitsPerPage = 10;
        IndexReader reader = DirectoryReader.open(index);
        IndexSearcher searcher = new IndexSearcher(reader);
        TopDocs docs = searcher.search(q, hitsPerPage);
        ScoreDoc[] hits = docs.scoreDocs;

        searchResults = FXCollections.observableArrayList();
        
        for(int i = 0;i < hits.length;i++){
        	
        	int docId = hits[i].doc;
        	Document d = searcher.doc(docId);
        	
        	Databaptis searchResult = new Databaptis();
        	searchResult.setPAROKI(d.get("PAROKI").toString());
        	searchResult.setKOTAPAROKI(d.get("KOTAPAROKI").toString());
        	searchResult.setKDSTASI(d.get("KDSTASI").toString());
        	searchResult.setNAMASTASI(d.get("NAMASTASI").toString());
        	searchResult.setBUKU(d.get("BUKU").toString());
        	searchResult.setHAL(Integer.valueOf(d.get("HAL")));
        	searchResult.setNO(Integer.valueOf(d.get("NO")));
        	searchResult.setNAMA(d.get("NAMA").toString());
        	searchResult.setJNKEL(Integer.valueOf(d.get("JNKEL")));
        	searchResult.setTMPLAHIR(d.get("TMPLAHIR"));
        	searchResult.setTGLLAHIR(new Date(Long.valueOf(d.get("TGLLAHIR"))));
        	searchResult.setTMPBAPTIS(d.get("TMPBAPTIS").toString());
        	searchResult.setTGLBAPTIS(new Date(Long.valueOf(d.get("TGLBAPTIS"))));
        	searchResult.setTERIMADR(d.get("TERIMADR").toString());
        	searchResult.setTERIMADI(d.get("TERIMADI").toString());
        	searchResult.setTERIMATGL(new Date(Long.valueOf(d.get("TERIMATGL"))));
        	searchResult.setAYAH(d.get("AYAH").toString());
        	searchResult.setIBU(d.get("IBU").toString());
        	searchResult.setWALIBAPTIS(d.get("WALIBAPTIS").toString());
        	searchResult.setYGBAPTIS(d.get("YGBAPTIS").toString());
        	searchResult.setYGTERIMA(d.get("YGTERIMA").toString());
        	searchResult.setPRKKRISMA(d.get("PRKKRISMA").toString());
        	searchResult.setTMPKRISMA(d.get("TMPKRISMA").toString());
        	searchResult.setTGLKRISMA(new Date(Long.valueOf(d.get("TGLKRISMA"))));
        	searchResult.setKWDENGAN(d.get("KWDENGAN"));
        	searchResult.setPRKKW(d.get("PRKKW"));
        	searchResult.setTMPKW(d.get("TMPKW"));
        	searchResult.setTGLKW(new Date(Long.valueOf(d.get("TGLKW"))));
        	searchResult.setLM(d.get("LM").toString());
        	searchResult.setLMNO(d.get("LMNO").toString());
        	searchResult.setTMPMATI(d.get("TMPMATI").toString());
        	searchResult.setTGLMATI(new Date(Long.valueOf(d.get("TGLMATI"))));
        	searchResult.setJNNOTANDA(Integer.valueOf(d.get("JNNOTANDA")));
        	searchResult.setNOTANDA(d.get("NOTANDA").toString());
        	searchResult.setNOTANDA1(d.get("NOTANDA1").toString());
        	searchResult.setNOTANDA2(new Date(Long.valueOf(d.get("NOTANDA2"))));
        	searchResult.setNOTANDA3(d.get("NOTANDA3").toString());
        	searchResult.setNOTANDA4(new Date(Long.valueOf(d.get("NOTANDA4"))));
        	searchResult.setNOTANDA5(d.get("NOTANDA5").toString());
        	
        	searchResults.add(searchResult);
        }
        
    }
    
    public ObservableList<Databaptis> getSearchResult(){
    	return searchResults;
    }

}
