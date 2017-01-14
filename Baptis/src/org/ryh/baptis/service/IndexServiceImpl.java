package org.ryh.baptis.service;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.IntField;
import org.apache.lucene.document.LongField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.jamel.dbf.processor.DbfProcessor;
import org.jamel.dbf.processor.DbfRowMapper;
import org.jrebirth.af.api.annotation.PriorityLevel;
import org.jrebirth.af.api.module.Register;
import org.jrebirth.af.api.wave.Wave;
import org.jrebirth.af.core.service.DefaultService;
import org.ryh.baptis.beans.Databaptis;


@Register(value = IndexService.class, priority = PriorityLevel.High)
public class IndexServiceImpl extends DefaultService implements IndexService{
	
	StandardAnalyzer analyzer;
	Directory index;
	List<Databaptis> indexedData;
	
	@Override
	protected void initService() {
		listen(DO_INDEXING);
	}
	
	@Override
	public void doIndexing(File file, Wave wave) throws IOException {
		analyzer = new StandardAnalyzer();
		index = new RAMDirectory();
		IndexWriterConfig config = new IndexWriterConfig(analyzer);
		IndexWriter w = new IndexWriter(index, config);
				
		File dbf = file;
		indexedData = DbfProcessor.loadData(dbf, new DbfRowMapper<Databaptis>() {
		@Override
		public Databaptis mapRow(Object[] row) {
		// here we can change string encoding if it is needed
		String PAROKI = new String((byte[]) row[0]);
		String KOTAPAROKI = new String((byte[]) row[1]);
		String KDSTASI = new String((byte[]) row[2]);
		String NAMASTASI = new String((byte[]) row[3]);
		String BUKU = new String((byte[]) row[4]);
		Number HAL = (Number) row[5];
		Number NO = (Number) row[6];
		String NAMA = new String((byte[]) row[7]);
		Number JNKEL = (Number) row[8];
		String TMPLAHIR = new String((byte[]) row[9]);
		Date TGLLAHIR = (Date) row[10];
		String TMPBAPTIS = new String((byte[]) row[11]);
		Date TGLBAPTIS = (Date) row[12];
		String TERIMADR = new String((byte[]) row[13]);
		String TERIMADI = new String((byte[]) row[14]);
		Date TERIMATGL = (Date) row[15];
		String AYAH = new String((byte[]) row[16]);
		String IBU = new String((byte[]) row[17]);
		String WALIBAPTIS = new String((byte[]) row[18]);
		String YGBAPTIS = new String((byte[]) row[19]);
		String YGTERIMA = new String((byte[]) row[20]);
		String PRKKRISMA = new String((byte[]) row[21]);
		String TMPKRISMA = new String((byte[]) row[22]);
		Date TGLKRISMA = (Date) row[23];
		String KWDENGAN = new String((byte[]) row[24]);
		String PRKKW = new String((byte[]) row[25]);
		String TMPKW = new String((byte[]) row[26]);
		Date TGLKW  = (Date) row[27];
		String LM = new String((byte[]) row[28]);
		String LMNO = new String((byte[]) row[29]);
		String TMPMATI = new String((byte[]) row[30]);
		Date TGLMATI  = (Date) row[31];
		Number JNNOTANDA = (Number) row[32];
		String NOTANDA = new String((byte[]) row[33]);
		String NOTANDA1 = new String((byte[]) row[34]);
		Date NOTANDA2  = (Date) row[35];
		String NOTANDA3 = new String((byte[]) row[36]);
		Date NOTANDA4  = (Date) row[37];
		String NOTANDA5 = new String((byte[]) row[38]);

		Document doc = new Document();
		doc.add(new TextField("PAROKI", PAROKI, Field.Store.YES));
		doc.add(new TextField("KOTAPAROKI", KOTAPAROKI, Field.Store.YES));
		doc.add(new TextField("KDSTASI", KDSTASI, Field.Store.YES));
		doc.add(new TextField("NAMASTASI", NAMASTASI, Field.Store.YES));
		doc.add(new TextField("BUKU", BUKU, Field.Store.YES));
		doc.add(new IntField("HAL", HAL.intValue(), Field.Store.YES));
		doc.add(new IntField("NO", NO.intValue(), Field.Store.YES));
		doc.add(new TextField("NAMA", NAMA, Field.Store.YES));
		doc.add(new IntField("JNKEL", JNKEL.intValue(), Field.Store.YES));
		doc.add(new TextField("TMPLAHIR", TMPLAHIR, Field.Store.YES));
		doc.add(new LongField("TGLLAHIR", TGLLAHIR.getTime(), Field.Store.YES));
		doc.add(new TextField("TMPBAPTIS", TMPBAPTIS, Field.Store.YES));
		doc.add(new LongField("TGLBAPTIS", TGLBAPTIS.getTime(), Field.Store.YES));
		doc.add(new TextField("TERIMADR", TERIMADR, Field.Store.YES));
		doc.add(new TextField("TERIMADI", TERIMADI, Field.Store.YES));
		doc.add(new LongField("TERIMATGL", TERIMATGL.getTime(), Field.Store.YES));
		doc.add(new TextField("AYAH", AYAH, Field.Store.YES));
		doc.add(new TextField("IBU", IBU, Field.Store.YES));
		doc.add(new TextField("WALIBAPTIS", WALIBAPTIS, Field.Store.YES));
		doc.add(new TextField("YGBAPTIS", YGBAPTIS, Field.Store.YES));
		doc.add(new TextField("YGTERIMA", YGTERIMA, Field.Store.YES));
		doc.add(new TextField("PRKKRISMA", PRKKRISMA, Field.Store.YES));
		doc.add(new TextField("TMPKRISMA", TMPKRISMA, Field.Store.YES));
		doc.add(new LongField("TGLKRISMA", TGLKRISMA.getTime(), Field.Store.YES));
		doc.add(new TextField("KWDENGAN", KWDENGAN, Field.Store.YES));
		doc.add(new TextField("PRKKW", PRKKW, Field.Store.YES));
		doc.add(new TextField("TMPKW", TMPKW, Field.Store.YES));
		doc.add(new LongField("TGLKW", TGLKW.getTime(), Field.Store.YES));
		doc.add(new TextField("LM", LM, Field.Store.YES));
		doc.add(new TextField("LMNO", LMNO, Field.Store.YES));
		doc.add(new TextField("TMPMATI", TMPMATI, Field.Store.YES));
		doc.add(new LongField("TGLMATI", TGLMATI.getTime(), Field.Store.YES));
		doc.add(new IntField("JNNOTANDA", JNNOTANDA.intValue(), Field.Store.YES));
		doc.add(new TextField("NOTANDA", NOTANDA, Field.Store.YES));
		doc.add(new TextField("NOTANDA1", NOTANDA1, Field.Store.YES));
		doc.add(new LongField("NOTANDA2", NOTANDA2.getTime(), Field.Store.YES));
		doc.add(new TextField("NOTANDA3", NOTANDA3, Field.Store.YES));
		doc.add(new LongField("NOTANDA4", NOTANDA4.getTime(), Field.Store.YES));
		doc.add(new TextField("NOTANDA5", TMPMATI, Field.Store.YES));

		try {
			w.addDocument(doc);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return new Databaptis(PAROKI, KOTAPAROKI, KDSTASI, NAMASTASI, BUKU, HAL.intValue(), NO.intValue(),
				NAMA, JNKEL.intValue(), TMPLAHIR, TGLLAHIR, TMPBAPTIS, TGLBAPTIS, 
				TERIMADR, TERIMADI, TERIMATGL, AYAH, IBU, WALIBAPTIS, YGBAPTIS, YGTERIMA, 
				PRKKRISMA, TMPKRISMA, TGLKRISMA, KWDENGAN, PRKKW, TMPKW, TGLKW,
				LM, LMNO, TMPMATI, TGLMATI, JNNOTANDA.intValue(), NOTANDA, NOTANDA1, 
				NOTANDA2, NOTANDA3, NOTANDA4, NOTANDA5);
		}
		});
		w.close();
	}

	@Override
	public Directory getIndex() {
		return index;
	}

	@Override
	public StandardAnalyzer getAnalyzer() {
		return analyzer;
	}

	@Override
	public List<Databaptis> getIndexedData() {
		return indexedData;
	}

}