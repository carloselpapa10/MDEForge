package org.mdeforge.artifactservice.dao;

import java.util.List;

import org.mdeforge.artifactservice.model.Artifact;
import org.mdeforge.artifactservice.model.Comment;
import org.mdeforge.artifactservice.model.Metric;
import org.mdeforge.servicemodel.common.BusinessException;

public interface ArtifactService <T extends Artifact>{

	/*public T create(T art) throws BusinessException;
	public void update(T artifact) throws BusinessException;
	public void delete(T artifact, UserInfo user) throws BusinessException;
	public void updateSimple(T artifact);
	public UserInfo addUserInArtifact(String idUser, String idArtifact, UserInfo user) throws BusinessException;
	public void removeUserFromArtifact(String idUser, String idArtifact) throws BusinessException;
	public UserInfo addUserInPublicArtifact(String idUser, String idArtifact, UserInfo user) throws BusinessException;
	public void addComment(Comment comment, String idArtifat) throws BusinessException;
	public boolean deleteTermFromIndex(String fieldName, String filePath);
	public void deleteComment(String idComment, String idArtifact);
	public void createLuceneIndex(T artifact);
	
	public boolean isArtifactInProject(String idProject, String idArtfact) throws BusinessException;
	public boolean isArtifactInUser(UserInfo idUser, String idArtfact)	throws BusinessException;
	public boolean existRelation(String idTo, String idFrom) throws BusinessException;
	
	public List<T> findAll() throws BusinessException;
	public List<T> findSharedNoProject(UserInfo user) throws BusinessException;
	public T findOne(String id) throws BusinessException;
	public List<T> findAllWithPublicByUser(UserInfo user) throws BusinessException;
	public List<T> findAllPublic() throws BusinessException;
	public List<T> findArtifactInProject(String idProject, UserInfo user);
	public T findOneByOwner(String idArtifact, UserInfo idUser);
	public T findOneById(String idArtifact, UserInfo idUser) throws BusinessException;
	public T findOneByName(String artifactName) throws BusinessException;
	public List<Metric> findMetricForArtifact(Artifact a);
	public T findOnePublic(String id) throws BusinessException;
	public T findOneByName(String name, UserInfo user) throws BusinessException;
	public List<T> findMyArtifacts(UserInfo user) throws BusinessException;
	public long countAll() throws BusinessException;
	public List<T> findRecentArtifacts() throws BusinessException;
	public List<T> findRecentArtifactsPublic() throws BusinessException;
	public List<T> findAllSharedByUser(UserInfo user);
	public T findOneInProject(String project_id, String artifact_id, UserInfo user) throws BusinessException;
	public List<Metric> findMetric(String idArtifact, UserInfo user) throws BusinessException;
	public List<String> getAllIndexTags();
	public List<String> getTagIndexes();
	public <K> List<K> findAll(Class<K> k);
	*/
	
	/*
	ResponseGrid<T> findAll(RequestGrid pag) throws BusinessException;
	ResponseGrid<T> findAllWithPublicByUser(User user, RequestGrid pag) throws BusinessException;
	ResponseGrid<T> findAllPublic(RequestGrid pag) throws BusinessException;
	ResponseGrid<T> findArtifactInProject(String idProject, User user, RequestGrid pag);
	ResponseGrid<T> findMyArtifacts(User user, RequestGrid pag);
	ResponseGrid<T> findAllSharedByUser(User user, RequestGrid pag);
	ResponseGrid<T> findMyArtifacts(User user, RequestGrid pag, boolean generated);
	
	List<Statistic> statistic();*/
	
	
}
