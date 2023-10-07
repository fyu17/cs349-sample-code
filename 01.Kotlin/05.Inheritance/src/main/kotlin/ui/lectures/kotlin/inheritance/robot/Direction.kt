package ui.lectures.kotlin.inheritance.robot

/**
 * Enumeration that represents one in four discrete directions.
 */
enum class Direction {
    /**
     * Represents the direction UP / NORTH
     */
    UP {
        /**
         * Rotates to [Direction.RIGHT]
         */
        override fun rotateRight(): Direction { return RIGHT }
       },

    /**
     * Represents the direction LEFT / EAST
     */
    LEFT {
        /**
         * Rotates to [Direction.UP]
         */
        override fun rotateRight(): Direction { return UP }
         },

    /**
     * Represents the direction DOWN / SOUTH
     */
    DOWN {
        /**
         * Rotates to [Direction.LEFT]
         */
        override fun rotateRight(): Direction { return LEFT }
         },

    /**
     * Represents the direction RIGHT / WEST
     */
    RIGHT {
        /**
         * Rotates to [Direction.DOWN]
         */
        override fun rotateRight(): Direction { return DOWN }
    };

    /**
     * Rotates one direction right / clock-wise.
     */
    abstract fun rotateRight() : Direction
}