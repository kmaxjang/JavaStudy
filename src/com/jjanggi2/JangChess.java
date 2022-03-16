package com.jjanggi2;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class JangChess implements Chess {

	private final boolean teams;
	private final Chess.type chesstype;
	private final Point position = new Point();
	private Point chackposition = new Point();
	private final Board board;
	private List<Point> list = new ArrayList<Point>();

	public JangChess(Board board, boolean teams, Chess.type chesstype, Point position) {
		this.board = board;
		this.teams = teams;
		this.chesstype = chesstype;
		this.position.setLocation(position);
	}

	@Override
	public boolean isTeams() {
		return teams;
	}

	@Override
	public Chess.type getType() {
		return chesstype;
	}

	@Override
	public Point getNowPosition() {
		return position.getLocation();
	}

	@Override
	public void setPosition(Point position) {
		this.position.setLocation(position);
	}

	@Override
	public List<Point> getMoveList() {
		list.clear();
		System.out.println("�̵� �˻�" + chesstype);
		switch (chesstype) {
		case KG:

		
		case SA:
			if (palace[0].equals(position) || palace[5].equals(position)) {

				if (!board.isCheck(Move.RT.getPoint(position)) || board.getChess(Move.RT.getPoint()).isTeams() != teams) {
					// add list
					list.add(Move.RT.getPoint().getLocation());
				}
				Move.RD.outCheck(position);
				if (!board.isCheck(Move.RD.getPoint()) || board.getChess(Move.RD.getPoint()).isTeams() != teams) {
					// add list
					list.add(Move.RD.getPoint().getLocation());
				}
				Move.DW.outCheck(position);
				if (!board.isCheck(Move.DW.getPoint()) || board.getChess(Move.DW.getPoint()).isTeams() != teams) {
					// add list
					list.add(Move.DW.getPoint().getLocation());
				}
			} else if (palace[1].equals(position) || palace[6].equals(position)) {
				Move.LT.outCheck(position);
				if (!board.isCheck(Move.LT.getPoint()) || board.getChess(Move.LT.getPoint()).isTeams() != teams) {
					// add list
					list.add(Move.LT.getPoint().getLocation());
				}
				Move.RT.outCheck(position);
				if (!board.isCheck(Move.RT.getPoint()) || board.getChess(Move.RT.getPoint()).isTeams() != teams) {
					// add list
					list.add(Move.RT.getPoint().getLocation());
				}
				Move.DW.outCheck(position);
				if (!board.isCheck(Move.DW.getPoint()) || board.getChess(Move.DW.getPoint()).isTeams() != teams) {
					// add list
					list.add(Move.DW.getPoint().getLocation());
				}
			} else if (palace[3].equals(position) || palace[4].equals(position)) {
				Move.LT.outCheck(position);
				if (!board.isCheck(Move.LT.getPoint()) || board.getChess(Move.LT.getPoint()).isTeams() != teams) {
					// add list
					list.add(Move.LT.getPoint().getLocation());
				}
				Move.LD.outCheck(position);
				if (!board.isCheck(Move.LD.getPoint()) || board.getChess(Move.LD.getPoint()).isTeams() != teams) {
					// add list
					list.add(Move.LD.getPoint().getLocation());
				}
				Move.DW.outCheck(position);
				if (!board.isCheck(Move.DW.getPoint()) || board.getChess(Move.DW.getPoint()).isTeams() != teams) {
					// add list
					list.add(Move.DW.getPoint().getLocation());
				}
			} else if (palace[0].equals(position) || palace[0].equals(position)) {
				Move.LT.outCheck(position);
				if (!board.isCheck(Move.LT.getPoint()) || board.getChess(Move.LT.getPoint()).isTeams() != teams) {
					// add list
					list.add(Move.LT.getPoint().getLocation());
				}
				Move.UP.outCheck(position);
				if (!board.isCheck(Move.UP.getPoint()) || board.getChess(Move.UP.getPoint()).isTeams() != teams) {
					// add list
					list.add(Move.UP.getPoint().getLocation());
				}
				Move.DW.outCheck(position);
				if (!board.isCheck(Move.DW.getPoint()) || board.getChess(Move.DW.getPoint()).isTeams() != teams) {
					// add list
					list.add(Move.DW.getPoint().getLocation());
				}
			} else if (palace[0].equals(position) || palace[0].equals(position)) {
				Move.LT.outCheck(position);
				if (!board.isCheck(Move.LT.getPoint()) || board.getChess(Move.LT.getPoint()).isTeams() != teams) {
					// add list
					list.add(Move.LT.getPoint().getLocation());
				}
				Move.UP.outCheck(position);
				if (!board.isCheck(Move.UP.getPoint()) || board.getChess(Move.UP.getPoint()).isTeams() != teams) {
					// add list
					list.add(Move.UP.getPoint().getLocation());
				}
				Move.LU.outCheck(position);
				if (!board.isCheck(Move.LU.getPoint()) || board.getChess(Move.LU.getPoint()).isTeams() != teams) {
					// add list
					list.add(Move.LU.getPoint().getLocation());
				}
			} else if (palace[0].equals(position) || palace[0].equals(position)) {
				Move.LT.outCheck(position);
				if (!board.isCheck(Move.LT.getPoint()) || board.getChess(Move.LT.getPoint()).isTeams() != teams) {
					// add list
					list.add(Move.LT.getPoint().getLocation());
				}
				Move.UP.outCheck(position);
				if (!board.isCheck(Move.UP.getPoint()) || board.getChess(Move.UP.getPoint()).isTeams() != teams) {
					// add list
					list.add(Move.UP.getPoint().getLocation());
				}
				Move.RT.outCheck(position);
				if (!board.isCheck(Move.RT.getPoint()) || board.getChess(Move.RT.getPoint()).isTeams() != teams) {
					// add list
					list.add(Move.RT.getPoint().getLocation());
				}
			} else if (palace[0].equals(position) || palace[0].equals(position)) {
				Move.UP.outCheck(position);
				if (!board.isCheck(Move.UP.getPoint()) || board.getChess(Move.UP.getPoint()).isTeams() != teams) {
					// add list
					list.add(Move.UP.getPoint().getLocation());
				}
				Move.RT.outCheck(position);
				if (!board.isCheck(Move.RT.getPoint()) || board.getChess(Move.RT.getPoint()).isTeams() != teams) {
					// add list
					list.add(Move.RT.getPoint().getLocation());
				}
				Move.RU.outCheck(position);
				if (!board.isCheck(Move.RU.getPoint()) || board.getChess(Move.RU.getPoint()).isTeams() != teams) {
					// add list
					list.add(Move.RU.getPoint().getLocation());
				}
			} else if (palace[0].equals(position) || palace[0].equals(position)) {
				Move.RT.outCheck(position);
				if (!board.isCheck(Move.RT.getPoint()) || board.getChess(Move.RT.getPoint()).isTeams() != teams) {
					// add list
					list.add(Move.RT.getPoint().getLocation());
				}
				Move.UP.outCheck(position);
				if (!board.isCheck(Move.UP.getPoint()) || board.getChess(Move.UP.getPoint()).isTeams() != teams) {
					// add list
					list.add(Move.UP.getPoint().getLocation());
				}
				Move.DW.outCheck(position);
				if (!board.isCheck(Move.DW.getPoint()) || board.getChess(Move.DW.getPoint()).isTeams() != teams) {
					// add list
					list.add(Move.DW.getPoint().getLocation());
				}
			} else if (palace[0].equals(position) || palace[0].equals(position)) {
				Move.UP.outCheck(position);
				if (!board.isCheck(Move.UP.getPoint()) || board.getChess(Move.UP.getPoint()).isTeams() != teams) {
					// add list
					list.add(Move.UP.getPoint().getLocation());
				}
				Move.RU.outCheck(position);
				if (!board.isCheck(Move.RU.getPoint()) || board.getChess(Move.RU.getPoint()).isTeams() != teams) {
					// add list
					list.add(Move.RU.getPoint().getLocation());
				}
				Move.RT.outCheck(position);
				if (!board.isCheck(Move.RT.getPoint()) || board.getChess(Move.RT.getPoint()).isTeams() != teams) {
					// add list
					list.add(Move.RT.getPoint().getLocation());
				}
				Move.RD.outCheck(position);
				if (!board.isCheck(Move.RD.getPoint()) || board.getChess(Move.RD.getPoint()).isTeams() != teams) {
					// add list
					list.add(Move.RD.getPoint().getLocation());
				}
				Move.DW.outCheck(position);
				if (!board.isCheck(Move.DW.getPoint()) || board.getChess(Move.DW.getPoint()).isTeams() != teams) {
					// add list
					list.add(Move.DW.getPoint().getLocation());
				}
				Move.LD.outCheck(position);
				if (!board.isCheck(Move.LD.getPoint()) || board.getChess(Move.LD.getPoint()).isTeams() != teams) {
					// add list
					list.add(Move.LD.getPoint().getLocation());
				}
				Move.LT.outCheck(position);
				if (!board.isCheck(Move.LT.getPoint()) || board.getChess(Move.LT.getPoint()).isTeams() != teams) {
					// add list
					list.add(Move.LT.getPoint().getLocation());
				}
				Move.LU.outCheck(position);
				if (!board.isCheck(Move.LU.getPoint()) || board.getChess(Move.LU.getPoint()).isTeams() != teams) {
					// add list
					list.add(Move.LU.getPoint().getLocation());
				}
			}

			break;
		case JU:
			chackposition.setLocation(position);
			if (teams) {
				if (Move.DW.outCheck(chackposition))
					if (!board.isCheck(Move.DW.getPoint()) || board.getChess(Move.DW.getPoint()).isTeams() != teams) {
						// add list
						list.add(Move.DW.getPoint().getLocation());
					}

			} else {
				if (Move.UP.outCheck(chackposition))
					if (!board.isCheck(Move.UP.getPoint()) || board.getChess(Move.UP.getPoint()).isTeams() != teams) {
						// add list
						list.add(Move.UP.getPoint().getLocation());
					}
			}
			if (Move.RT.outCheck(chackposition))
				if (!board.isCheck(Move.RT.getPoint()) || board.getChess(Move.RT.getPoint()).isTeams() != teams) {
					// add list
					list.add(Move.RT.getPoint().getLocation());
				}
			if (Move.LT.outCheck(chackposition))
				if (!board.isCheck(Move.LT.getPoint()) || board.getChess(Move.LT.getPoint()).isTeams() != teams) {
					// add list
					list.add(Move.LT.getPoint().getLocation());
				}
			break;
		case SN:
			chackposition.setLocation(position);
			if (Move.UP.outCheck(chackposition) && !board.isCheck(Move.UP.getPoint())) {
				if (Move.LU.outCheck(Move.UP.getPoint()) && !board.isCheck(Move.LU.getPoint())) {
					if (Move.LU.outCheck(Move.LU.getPoint())) {
						if (!board.isCheck(Move.LU.getPoint())
								|| board.getChess(Move.LU.getPoint()).isTeams() != teams) {
							// add list
							list.add(Move.LU.getPoint().getLocation());
						}
					}
				}
				if (Move.RU.outCheck(Move.UP.getPoint()) && !board.isCheck(Move.RU.getPoint())) {
					if (Move.RU.outCheck(Move.RU.getPoint())) {
						if (!board.isCheck(Move.RU.getPoint())
								|| board.getChess(Move.RU.getPoint()).isTeams() != teams) {
							// add list
							list.add(Move.RU.getPoint().getLocation());
						}
					}
				}
			}
			if (Move.LT.outCheck(chackposition) && !board.isCheck(Move.LT.getPoint())) {
				if (Move.LU.outCheck(Move.LT.getPoint()) && !board.isCheck(Move.LU.getPoint())) {
					if (Move.LU.outCheck(Move.LU.getPoint())) {
						if (!board.isCheck(Move.LU.getPoint())
								|| board.getChess(Move.LU.getPoint()).isTeams() != teams) {
							// add list
							list.add(Move.LU.getPoint().getLocation());
						}
					}
				}
				if (Move.RD.outCheck(Move.LT.getPoint()) && !board.isCheck(Move.RD.getPoint())) {
					if (Move.RD.outCheck(Move.RD.getPoint())) {
						if (!board.isCheck(Move.RD.getPoint())
								|| board.getChess(Move.RD.getPoint()).isTeams() != teams) {
							// add list
							list.add(Move.RD.getPoint().getLocation());
						}
					}
				}
			}
			if (Move.DW.outCheck(chackposition) && !board.isCheck(Move.DW.getPoint())) {
				if (Move.LD.outCheck(Move.DW.getPoint()) && !board.isCheck(Move.LD.getPoint())) {
					if (Move.LD.outCheck(Move.LD.getPoint())) {
						if (!board.isCheck(Move.LD.getPoint())
								|| board.getChess(Move.LD.getPoint()).isTeams() != teams) {
							// add list
							list.add(Move.LD.getPoint().getLocation());
						}
					}
				}
				if (Move.RD.outCheck(Move.DW.getPoint()) && !board.isCheck(Move.RD.getPoint())) {
					if (Move.RD.outCheck(Move.RD.getPoint())) {
						if (!board.isCheck(Move.RD.getPoint())
								|| board.getChess(Move.RD.getPoint()).isTeams() != teams) {
							// add list
							list.add(Move.RD.getPoint().getLocation());
						}
					}
				}
			}
			if (Move.LT.outCheck(chackposition) && !board.isCheck(Move.LT.getPoint()))

				if (Move.LU.outCheck(Move.LT.getPoint()) && !board.isCheck(Move.LU.getPoint())) {
					if (Move.LU.outCheck(Move.LU.getPoint())) {
						if (!board.isCheck(Move.LU.getPoint())
								|| board.getChess(Move.LU.getPoint()).isTeams() != teams) {
							// add list
							list.add(Move.LU.getPoint().getLocation());
						}
					}
				}
			if (Move.LD.outCheck(Move.LT.getPoint()) && !board.isCheck(Move.LD.getPoint())) {
				if (Move.LD.outCheck(Move.LD.getPoint())) {
					if (!board.isCheck(Move.LD.getPoint()) || board.getChess(Move.LD.getPoint()).isTeams() != teams) {
						// add list
						list.add(Move.LD.getPoint().getLocation());
					}
				}
			}

			break;
		case MA:
			chackposition.setLocation(position);
			if (Move.UP.outCheck(chackposition) && !board.isCheck(Move.UP.getPoint())) {
				if (Move.LU.outCheck(Move.UP.getPoint())) {
					if (!board.isCheck(Move.LU.getPoint()) || board.getChess(Move.LU.getPoint()).isTeams() != teams) {
						// add list
						list.add(Move.LU.getPoint().getLocation());
					}
				}
				if (Move.RU.outCheck(Move.UP.getPoint())) {
					if (!board.isCheck(Move.RU.getPoint()) || board.getChess(Move.RU.getPoint()).isTeams() != teams) {
						// add list
						list.add(Move.RU.getPoint().getLocation());
					}
				}
			}
			if (Move.RT.outCheck(chackposition) && !board.isCheck(Move.RT.getPoint())) {
				if (Move.RU.outCheck(Move.RT.getPoint())) {
					if (!board.isCheck(Move.RU.getPoint()) || board.getChess(Move.RU.getPoint()).isTeams() != teams) {
						// add list
						list.add(Move.RU.getPoint().getLocation());
					}
				}
				if (Move.RD.outCheck(Move.RT.getPoint())) {
					if (!board.isCheck(Move.RD.getPoint()) || board.getChess(Move.RD.getPoint()).isTeams() != teams) {
						// add list
						list.add(Move.RD.getPoint().getLocation());
					}
				}
			}
			if (Move.DW.outCheck(chackposition) && !board.isCheck(Move.DW.getPoint())) {
				if (Move.LD.outCheck(Move.DW.getPoint())) {
					if (!board.isCheck(Move.LD.getPoint()) || board.getChess(Move.LD.getPoint()).isTeams() != teams) {
						// add list
						list.add(Move.LD.getPoint().getLocation());
					}
				}
				if (Move.RD.outCheck(Move.DW.getPoint())) {
					if (!board.isCheck(Move.RD.getPoint()) || board.getChess(Move.RD.getPoint()).isTeams() != teams) {
						// add list
						list.add(Move.RD.getPoint().getLocation());
					}
				}
			}
			if (Move.LT.outCheck(chackposition) && !board.isCheck(Move.LT.getPoint())) {
				if (Move.LU.outCheck(Move.LT.getPoint())) {
					if (!board.isCheck(Move.LU.getPoint()) || board.getChess(Move.LU.getPoint()).isTeams() != teams) {
						// add list
						list.add(Move.LU.getPoint().getLocation());
					}
				}
				if (Move.LD.outCheck(Move.LT.getPoint())) {
					if (!board.isCheck(Move.LD.getPoint()) || board.getChess(Move.LD.getPoint()).isTeams() != teams) {
						// add list
						list.add(Move.LD.getPoint().getLocation());
					}
				}
			}
			break;
		case PO:

			chackposition.setLocation(position);
			while (Move.UP.outCheck(chackposition)) {
				if (board.isCheck(Move.UP.getPoint())) {
					if (board.getChess(Move.UP.getPoint()).getType() != Chess.type.PO) {
						while (Move.UP.outCheck(Move.UP.getPoint())) {
							if (board.isCheck(Move.UP.getPoint())) {
								if (board.getChess(Move.UP.getPoint()).isTeams() != teams
										&& board.getChess(Move.UP.getPoint()).getType() != Chess.type.PO) {
									// add list
									list.add(Move.UP.getPoint().getLocation());
								}
								break;
							}
							// add list
							list.add(Move.UP.getPoint().getLocation());
						}
					}
					break;
				}
				chackposition.setLocation(Move.UP.getPoint());
			}

			chackposition.setLocation(position);
			while (Move.RT.outCheck(chackposition)) {
				if (board.isCheck(Move.RT.getPoint())) {
					if (board.getChess(Move.RT.getPoint()).getType() != Chess.type.PO) {
						while (Move.RT.outCheck(Move.RT.getPoint())) {
							if (board.isCheck(Move.RT.getPoint())) {
								if (board.getChess(Move.RT.getPoint()).isTeams() != teams
										&& board.getChess(Move.RT.getPoint()).getType() != Chess.type.PO) {
									// add list
									list.add(Move.UP.getPoint().getLocation());
								}
								break;
							}
							// add list
							list.add(Move.UP.getPoint().getLocation());
						}
					}
					break;
				}
				chackposition.setLocation(Move.RT.getPoint());
			}

			chackposition.setLocation(position);
			while (Move.DW.outCheck(chackposition)) {
				if (board.isCheck(Move.DW.getPoint())) {
					if (board.getChess(Move.DW.getPoint()).getType() != Chess.type.PO) {
						while (Move.DW.outCheck(Move.DW.getPoint())) {
							if (board.isCheck(Move.DW.getPoint())) {
								if (board.getChess(Move.DW.getPoint()).isTeams() != teams
										&& board.getChess(Move.DW.getPoint()).getType() != Chess.type.PO) {
									// add list
									list.add(Move.DW.getPoint().getLocation());
								}
								break;
							}
							// add list
							list.add(Move.DW.getPoint().getLocation());
						}
					}
					break;
				}
				chackposition.setLocation(Move.DW.getPoint());
			}

			chackposition.setLocation(position);
			while (Move.LT.outCheck(chackposition)) {
				if (board.isCheck(Move.LT.getPoint())) {
					if (board.getChess(Move.LT.getPoint()).getType() != Chess.type.PO) {
						while (Move.LT.outCheck(Move.LT.getPoint())) {
							if (board.isCheck(Move.LT.getPoint())) {
								if (board.getChess(Move.LT.getPoint()).isTeams() != teams
										&& board.getChess(Move.LT.getPoint()).getType() != Chess.type.PO) {
									// add list
									list.add(Move.LT.getPoint().getLocation());
								}
								break;
							}
							// add list
							list.add(Move.LT.getPoint().getLocation());
						}
					}
					break;
				}
				chackposition.setLocation(Move.LT.getPoint());
			}

			if (palace[0].equals(position) || palace[5].equals(position)) {
				Move.RD.outCheck(position);
				if (!board.isCheck(Move.RD.getPoint())
						&& board.getChess(Move.RD.getPoint()).getType() != Chess.type.PO) {
					Move.RD.outCheck(Move.RD.getPoint());
					if (board.isCheck(Move.RD.getPoint())) {
						if (board.getChess(Move.RD.getPoint()).isTeams() != teams
								&& board.getChess(Move.RD.getPoint()).getType() != Chess.type.PO) {
							// add list
							list.add(Move.RD.getPoint().getLocation());
						}
					} else {
						// add list
						list.add(Move.RD.getPoint().getLocation());
					}
				}

			} else if (palace[1].equals(position) || palace[6].equals(position)) {
				Move.LD.outCheck(position);
				if (board.isCheck(Move.LD.getPoint())) {
					if (board.getChess(Move.LD.getPoint()).getType() != Chess.type.PO) {
						Move.LD.outCheck(Move.LD.getPoint());
						if (board.isCheck(Move.LD.getPoint())) {
							if (board.getChess(Move.LD.getPoint()).isTeams() != teams
									&& board.getChess(Move.LD.getPoint()).getType() != Chess.type.PO) {
								// add list
								list.add(Move.LD.getPoint().getLocation());
							}
						} else {
							// add list
							list.add(Move.LD.getPoint().getLocation());
						}
					}
				}
			} else if (palace[3].equals(position) || palace[8].equals(position)) {
				Move.LU.outCheck(position);
				if (board.isCheck(Move.LU.getPoint())) {
					if (board.getChess(Move.LU.getPoint()).getType() != Chess.type.PO) {
						Move.LU.outCheck(Move.LU.getPoint());
						if (board.isCheck(Move.LU.getPoint())) {
							if (board.getChess(Move.LU.getPoint()).isTeams() != teams
									&& board.getChess(Move.LU.getPoint()).getType() != Chess.type.PO) {
								// add list
								list.add(Move.LU.getPoint().getLocation());
							}
						} else {
							// add list
							list.add(Move.LU.getPoint().getLocation());
						}
					}
				}

			} else if (palace[4].equals(position) || palace[9].equals(position)) {
				Move.RU.outCheck(position);
				if (board.isCheck(Move.RU.getPoint())) {
					if (board.getChess(Move.RU.getPoint()).getType() != Chess.type.PO) {
						Move.RU.outCheck(Move.RU.getPoint());
						if (board.isCheck(Move.RU.getPoint())) {
							if (board.getChess(Move.RU.getPoint()).isTeams() != teams
									&& board.getChess(Move.RU.getPoint()).getType() != Chess.type.PO) {
								// add list
								list.add(Move.RU.getPoint().getLocation());
							}
						} else {
							// add list
							list.add(Move.RU.getPoint().getLocation());
						}
					}
				}
			}
			break;
		case CH:

			chackposition.setLocation(position);
			while (Move.UP.outCheck(chackposition)) {
				if (board.isCheck(Move.UP.getPoint())) {
					if (board.getChess(Move.UP.getPoint()).isTeams() != teams) {
						// add list
						list.add(Move.UP.getPoint().getLocation());
					}
					break;
				}
				// add list
				list.add(Move.UP.getPoint().getLocation());
				chackposition.setLocation(Move.UP.getPoint());
			}

			chackposition.setLocation(position);
			while (Move.RT.outCheck(chackposition)) {
				if (board.isCheck(Move.RT.getPoint())) {
					if (board.getChess(Move.RT.getPoint()).isTeams() != teams) {
						// add list
						list.add(Move.RT.getPoint().getLocation());
					}
					break;
				}
				// add list
				list.add(Move.RT.getPoint().getLocation());
				chackposition.setLocation(Move.RT.getPoint());
			}

			chackposition.setLocation(position);
			while (Move.DW.outCheck(chackposition)) {
				if (board.isCheck(Move.DW.getPoint())) {
					if (board.getChess(Move.DW.getPoint()).isTeams() != teams) {
						// add list
						list.add(Move.DW.getPoint().getLocation());
					}
					break;
				}
				// add list
				list.add(Move.DW.getPoint().getLocation());
				chackposition.setLocation(Move.DW.getPoint());
			}

			chackposition.setLocation(position);
			while (Move.LT.outCheck(chackposition)) {
				if (board.isCheck(Move.LT.getPoint())) {
					if (board.getChess(Move.LT.getPoint()).isTeams() != teams) {
						// add list
						list.add(Move.LT.getPoint().getLocation());
					}
					break;
				}
				// add list
				list.add(Move.LT.getPoint().getLocation());
				chackposition.setLocation(Move.LT.getPoint());
			}

			chackposition.setLocation(position);
			if (palace[0].equals(position) || palace[5].equals(position)) {
				Move.RD.outCheck(position);
				if (board.isCheck(Move.RD.getPoint())) {
					if (board.getChess(Move.RD.getPoint()).isTeams() != teams) {
						// add list
						list.add(Move.RD.getPoint().getLocation());
					}
				} else {
					// add list
					list.add(Move.RD.getPoint().getLocation());
					Move.RD.outCheck(chackposition);
					if (board.isCheck(Move.RD.getPoint())) {
						if (board.getChess(Move.RD.getPoint()).isTeams() != teams) {
							// add list
							list.add(Move.RD.getPoint().getLocation());
						}
					} else {
						// add list
						list.add(Move.RD.getPoint().getLocation());
					}
				}

			} else if (palace[1].equals(position) || palace[6].equals(position)) {
				Move.LD.outCheck(position);
				if (board.isCheck(Move.LD.getPoint())) {
					if (board.getChess(Move.LD.getPoint()).isTeams() != teams) {
						// add list
						list.add(Move.LD.getPoint().getLocation());
					}
				} else {
					// add list
					list.add(Move.LD.getPoint().getLocation());
					Move.LD.outCheck(chackposition);
					if (board.isCheck(Move.LD.getPoint())) {
						if (board.getChess(Move.LD.getPoint()).isTeams() != teams) {
							// add list
							list.add(Move.LD.getPoint().getLocation());
						}
					} else {
						// add list
						list.add(Move.LD.getPoint().getLocation());
					}
				}

			} else if (palace[2].equals(position) || palace[7].equals(position)) {
				Move.LU.outCheck(position);
				if (board.isCheck(Move.LU.getPoint())) {
					if (board.getChess(Move.LU.getPoint()).isTeams() != teams) {
						// add list
						list.add(Move.LU.getPoint().getLocation());
					}
				} else {
					// add list
					list.add(Move.LU.getPoint().getLocation());
				}
				Move.RU.outCheck(position);
				if (board.isCheck(Move.RU.getPoint())) {
					if (board.getChess(Move.RU.getPoint()).isTeams() != teams) {
						// add list
						list.add(Move.RU.getPoint().getLocation());
					}
				} else {
					// add list
					list.add(Move.RU.getPoint().getLocation());
				}
				Move.RD.outCheck(position);
				if (board.isCheck(Move.RD.getPoint())) {
					if (board.getChess(Move.RD.getPoint()).isTeams() != teams) {
						// add list
						list.add(Move.RD.getPoint().getLocation());
					}
				} else {
					// add list
					list.add(Move.RD.getPoint().getLocation());
				}
				Move.LD.outCheck(position);
				if (board.isCheck(Move.LD.getPoint())) {
					if (board.getChess(Move.LD.getPoint()).isTeams() != teams) {
						// add list
						list.add(Move.LD.getPoint().getLocation());
					}
				} else {
					// add list
					list.add(Move.LD.getPoint().getLocation());
				}

			} else if (palace[3].equals(position) || palace[8].equals(position)) {
				Move.LU.outCheck(position);
				if (board.isCheck(Move.LU.getPoint())) {
					if (board.getChess(Move.LU.getPoint()).isTeams() != teams) {
						// add list
						list.add(Move.LU.getPoint().getLocation());
					}
				} else {
					// add list
					list.add(Move.LU.getPoint().getLocation());
					Move.LU.outCheck(chackposition);
					if (board.isCheck(Move.LU.getPoint())) {
						if (board.getChess(Move.LU.getPoint()).isTeams() != teams) {
							// add list
							list.add(Move.LU.getPoint().getLocation());
						}
					} else {
						// add list
						list.add(Move.LU.getPoint().getLocation());
					}
				}

			} else if (palace[4].equals(position) || palace[9].equals(position)) {
				Move.RU.outCheck(position);
				if (board.isCheck(Move.RU.getPoint())) {
					if (board.getChess(Move.RU.getPoint()).isTeams() != teams) {
						// add list
						list.add(Move.RU.getPoint().getLocation());
					}
				} else {
					// add list
					list.add(Move.RU.getPoint().getLocation());
					Move.RU.outCheck(chackposition);
					if (board.isCheck(Move.RU.getPoint())) {
						if (board.getChess(Move.RU.getPoint()).isTeams() != teams) {
							// add list
							list.add(Move.RU.getPoint().getLocation());
						}
					} else {
						// add list
						list.add(Move.RU.getPoint().getLocation());
					}
				}
			}
			break;
		}
		return list;
	}

	/*
	 * ����ǥ
	 */
	private Point[] palace = { new Point(3, 0), new Point(5, 0), new Point(4, 1), new Point(3, 2), new Point(5, 2),
			new Point(3, 7), new Point(5, 7), new Point(4, 8), new Point(3, 9), new Point(5, 9) };

	/*
	 * ���� ��ǥ�˻�
	 */
	private enum Move {
//	     up          right_Up   right    right_Down down   left_Down  left         left_Up
//		�ð���� ����.
		UP(0, -1), RU(1, -1), RT(1, 0), RD(1, 1), DW(0, 1), LD(-1, 1), LT(-1, 0), LU(-1, -1);
	
		private Point route; // �̵�����
		private Point movepoint = new Point(); // �̵��� ��ǥ
// ������ �ʱ� ���⼳��
		private Move(int x, int y) {
			route = new Point(x, y);
		}
// �̵���ǥ (��ǥ�˻��� ��ȿ)
		public Point getPoint() {
			return movepoint;
		}
// �̵���ǥ
		public Point getPoint(Point nowpoint) {			
			return new Point(nowpoint.x + route.x, nowpoint.y + route.y);
		}
		
		public boolean outCheck(Point nowpoint) {
// �̵���ǥ����
			movepoint.move(nowpoint.x + route.x, nowpoint.y + route.y);			
// �̵���ǥ �˻�
			switch (this) {
			case UP:
				if (movepoint.y <= -1) 
					return false;
				break;
			case RU:
				if (movepoint.x >= Board.maxx || movepoint.y <= -1)
					return false;
				break;
			case RT:
				if (movepoint.x >= Board.maxx)
					return false;
				break;
			case RD:
				if (movepoint.x >= Board.maxx || movepoint.y >= Board.maxy)
					return false;
				break;
			case DW:
				if (movepoint.y >= Board.maxy)
					return false;
				break;
			case LD:
				if (movepoint.x <= -1 || movepoint.y >= Board.maxy)
					return false;
				break;
			case LT:
				if (movepoint.x <= -1)
					return false;
				break;
			case LU:
				if (movepoint.x <= -1 || movepoint.y <= -1)
					return false;
				break;
			}
			return true;
		}
	};
}
