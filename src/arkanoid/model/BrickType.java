package arkanoid.model;

public enum BrickType
{
	//the field is occupied with a singleBrick
	SB,
	//the field is occupied with a singleBrick, that spawns balls
	SBBALL,
	//the field is occupied with a singleBrick, that falls down
	SBFALL,
	//the field is occupied with a singleBrick, that drops an enlarge-powerup
	SBENLARGE,
	//the field is occupied with a singleBrick, that drops a shorten-powerup
	SBSHORTEN,
	//the field is occupied with a singleBrick, that drops a fast-powerup
	SBFAST,
	//the field is occupied with a singleBrick, that drops a slow-powerup
	SBSLOW,
	//the field is occupied with a tripleBrick
	TB,
	//the field is occupied with a tripleBrick, that spawns balls
	TBBALL,
	//the field is occupied with a tripleBrick, that spawns a portal
	TBPORTAL
	;

} //end enum BrickType
