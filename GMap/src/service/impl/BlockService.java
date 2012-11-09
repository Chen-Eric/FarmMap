/**
 * 
 */
package service.impl;

import java.util.List;

import dao.IBlockDAO;
import domain.Block;
import domain.BlockId;
import domain.Farm;
import service.IBlockService;

/**
 * @author Chen
 *
 */
public class BlockService implements IBlockService {

	private IBlockDAO blockDAO;
	
	public IBlockDAO getBlockDAO() {
		return blockDAO;
	}

	public void setBlockDAO(IBlockDAO blockDAO) {
		this.blockDAO = blockDAO;
	}

	/* (non-Javadoc)
	 * @see service.IBlockService#addBlock(domain.Block)
	 */
	@Override
	public void addBlock(Block block) {
		blockDAO.save(block);
	}

	/* (non-Javadoc)
	 * @see service.IBlockService#deleteBlock(domain.Block)
	 */
	@Override
	public void deleteBlock(Block block) {
		blockDAO.delete(block);
	}

	/* (non-Javadoc)
	 * @see service.IBlockService#updateBlock(domain.Block)
	 */
	@Override
	public void updateBlock(Block block) {
		blockDAO.updateBlock(block);
	}

	/* (non-Javadoc)
	 * @see service.IBlockService#finBlockById()
	 */
	@Override
	public Block finBlockById(BlockId blockId) {
		return blockDAO.findById(blockId);
	}

	/* (non-Javadoc)
	 * @see service.IBlockService#findBlockByFarmId()
	 */
	@Override
	public List<Block> findBlockByFarmId(domain.Farm farm) {
		return blockDAO.findByProperty("id.farm", farm);
	}

	/* (non-Javadoc)
	 * @see service.IBlockService#findAllBlocks()
	 */
	@Override
	public List<Block> findAllBlocks() {
		return blockDAO.findAll();
	}

}
