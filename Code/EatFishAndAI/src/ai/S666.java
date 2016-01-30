package ai;

import java.util.List;

import fishhandles.OtherFish;
import fishhandles.YourFish;

public class S666 extends AbstractAI {


	YourFish fish;
	
	List<ScanArea> MySones;

	@Override
	public void init(YourFish fish) {
		this.fish = fish;
	}

	@Override
	public void update(List<OtherFish> otherFish) {

	}

	@Override
	public void ateFish(OtherFish handle) {

	}
	
	// find how many fish there are in the target area
	public ScanArea scanAreaTarget(List<OtherFish> otherFish) {
		for (int i = 0; i < otherFish.size(); i++) {
			if (fish.distanceTo(otherFish.get(i)) == 0) {
				
			}
		}
		return null;
		
	}
	
	// check if there are any enemies bigger than you in the target area
	public ScanArea resolveArea(String id) {
		return null;
	}
	
	public ScanArea resolvePotential(String id) {
		return null;
	}
	
	public class Target {
		
		private int id;						// Id's the target
		private float targetDist;			// Distance to the target
		private float targetSize;			// Size of the target
		public boolean potentialPlayer;		// Tells if the fish could be player AI

		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public float getTargetDist() {
			return targetDist;
		}
		public void setTargetDist(float targetDist) {
			this.targetDist = targetDist;
		}
		public float getTargetSize() {
			return targetSize;
		}
		public void setTargetSize(float targetSize) {
			this.targetSize = targetSize;
		}
		public boolean isPotentialPlayer() {
			return potentialPlayer;
		}
		public void setPotentialPlayer(boolean potentialPlayer) {
			this.potentialPlayer = potentialPlayer;
		}
	}
	
	public class ScanArea {
		private int id; 				// Id's the fish in scanned area
		private int potentialSupplier; 	// gives amount of potential supplier
		private int potentialFoes; 		// gives amount of potential foes
		private int Foes; 				// gives amount of fish that are bigger than you
		private int areaPotential; 		// gives a number 1- 10 telling you how good the zone is
		private List<Target> Targets;	// List of Target types of all fish in this area
		

		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getPotentialSupplier() {
			return potentialSupplier;
		}
		public void setPotentialSupplier(int potentialSupplier) {
			this.potentialSupplier = potentialSupplier;
		}
		public int getPotentialFoes() {
			return potentialFoes;
		}
		public void setPotentialFoes(int potentialFoes) {
			this.potentialFoes = potentialFoes;
		}
		public int getFoes() {
			return Foes;
		}
		public void setFoes(int foes) {
			Foes = foes;
		}
		public int getAreaPotential() {
			return areaPotential;
		}
		public void setAreaPotential(int potential) {
			this.areaPotential = potential;
		}
		public List<Target> getTargets() {
			return Targets;
		}
		public void setTargets(List<Target> targets) {
			Targets = targets;
		}

	}

}
