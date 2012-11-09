package service;

import java.util.List;

import domain.Block;
import domain.BlockId;

/**
 * @author Chen
 *
 */
public interface IBlockService {
	
	public void addBlock(Block block);
	
	public void deleteBlock(Block block);
	
	public void updateBlock(Block block);
	
	public Block finBlockById(BlockId blockId);
	
	public List<Block> findBlockByFarmId(domain.Farm farm);
	
	public List<Block> findAllBlocks();
}
