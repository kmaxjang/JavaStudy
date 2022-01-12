package com.janggi.game.piece;

import com.janggi.game.util.Group;
import com.janggi.game.util.MovePoints;
import com.janggi.game.Board;
import com.janggi.game.Msg;
import com.janggi.game.Piece;
import com.janggi.game.Point;
import com.janggi.game.util.PieceSet;
import com.janggi.game.util.Piecebuild;

public final class Cha extends Piece implements Piecebuild {

	private Board<Piece> board;
	private MovePoints movepoints;
	private Point piece_now_point = new Point();

	// 예비 값
	private Piece tmppiece = null;
	private Point tmp = new Point();
	private Point tmp2 = new Point();

	public Cha(Board<Piece> board, Group group, PieceSet piece, Point nowpoint) {
		super(group, piece);
		this.board = board;
		piece_now_point.set(nowpoint);
		setting();
	}

	@Override
	public boolean setMove(Point move) {
		boolean moveflag = movepoints.comper(move);
		if (moveflag) {
			piece_now_point.set(move);
		}
		return moveflag;
	}

	@Override
	public MovePoints getMoveList() {
		return new MovePoints(movepoints);
	}

	private void setting() {
		int length = 21;
		switch (piece) {
		case CHA:
			length = 21;
			break;
		case JOL:
			length = 5;
			break;
		case KING:
			length = 8;
			break;
		case MA:
			length = 8;
			break;
		case POO:
			length = 14;
			break;
		case SA:
			length = 9;
			break;
		case SANG:
			length = 8;
			break;
		default:
			break;
		}
		movepoints = new MovePoints(length);
	}

	private void moveChack() {
		switch (piece) {
		case CHA:
			// 차
			// 상 우 하 좌
			for (int w = 0; w < 4; w++) {
				tmp.set(piece_now_point);
				while (true) {
					tmp.move(way[w]);
					if (board.inLine(tmp)) {
						if (board.isPiece(tmp)) {
							if (!board.getPiece(tmp).equals(group)) {
								// 기록
								Msg.print("말" + tmp);
								movepoints.add(tmp);
							}
						} else {
							// 기록
							Msg.print("공백" + tmp);
							movepoints.add(tmp);
							continue;
						}
					}
					break;
				}
			}
			// 궁
			boolean centerflag = true;
			tmp.set(piece_now_point);
			for (int edge = 0; edge < 4; edge++) {
				if (tmp.comper(palace_edge_point[edge]) || tmp.comper(palace_edge_point[edge + 4])) {
					int diagonal = (edge + 2) % 4;
					tmp.move(way_diagonal[diagonal]);
					if (board.isPiece(tmp)) {
						if (!board.getPiece(tmp).equals(group)) {
							// 기록
							Msg.print("말" + tmp);
							movepoints.add(tmp);
						}
					} else {
						// 기록
						Msg.print("공백" + tmp);
						movepoints.add(tmp);
						tmp.move(way_diagonal[diagonal]);
						if (board.isPiece(tmp)) {
							if (!board.getPiece(tmp).equals(group)) {
								// 기록
								Msg.print("말" + tmp);
								movepoints.add(tmp);
							}
						} else {
							// 기록
							Msg.print("공백" + tmp);
							movepoints.add(tmp);
						}
					}
					centerflag = false;
					break;
				}
			}
			if (centerflag && tmp.comper(palace_center_point[0]) || tmp.comper(palace_center_point[1])) {
				int edge = (tmp.y == 1) ? 0 : 4;
				for (int diagonal = edge; diagonal < edge + 4; diagonal++) {
					tmp.set(palace_edge_point[diagonal]);
					if (board.isPiece(tmp)) {
						if (!board.getPiece(tmp).equals(group)) {
							// 기록
							Msg.print("말" + tmp);
							movepoints.add(tmp);
						}
					} else {
						// 기록
						Msg.print("공백" + tmp);
						movepoints.add(tmp);
					}
				}
			}
			break;
		case POO:
			// 포
			// 상 우 하 좌
			for (int w = 0; w < 4; w++) {
				tmp.set(piece_now_point);
				while (true) {
					tmp.move(way[w]);
					if (board.inLine(tmp)) {
						if (board.isPiece(tmp)) {
							if (!board.getPiece(tmp).equals(PieceSet.POO)) {
								while (true) {
									tmp.move(way[w]);
									if (board.inLine(tmp)) {
										if (board.isPiece(tmp)) {
											tmppiece = board.getPiece(tmp);
											if (!tmppiece.equals(group) && !tmppiece.equals(PieceSet.POO)) {
												// 기록
												Msg.print("말" + tmp);
												movepoints.add(tmp);
											}
										} else {
											// 기록
											Msg.print("공백" + tmp);
											movepoints.add(tmp);
											continue;
										}
									}
									break;
								}
							}
						} else {
							continue;
						}
					}
					break;
				}
			}
			// 궁
			tmp.set(piece_now_point);
			for (int edge = 0; edge < palace_edge_point.length; edge++) {
				if (tmp.comper(palace_edge_point[edge])) {
					tmp.set(palace_center_point[edge < 4 ? 0 : 1]);
					if (board.isPiece(tmp) && !board.getPiece(tmp).equals(PieceSet.POO)) {
						tmp.set(palace_edge_point[(edge + 2) % 4 + (edge < 4 ? 0 : 4)]);
						if (board.isPiece(tmp)) {
							tmppiece = board.getPiece(tmp);
							if (!tmppiece.equals(group) && !tmppiece.equals(PieceSet.POO)) {
								// 기록
								Msg.print("말" + tmp);
								movepoints.add(tmp);
							}
						} else {
							// 기록
							Msg.print("공백" + tmp);
							movepoints.add(tmp);
						}
					}
					break;
				}
			}
			break;
		case MA:
			// 마
			// 상 우 하 좌
			for (int w = 0; w < 4; w++) {
				tmp.set(piece_now_point);
				tmp.move(way[w]);
				if (board.inLine(tmp) && !board.isPiece(tmp)) {
					for (int w2 = 3; w2 < 5; w2++) {
						tmp2.set(tmp);
						tmp2.move(way_diagonal[(w + w2) % 4]);
						if (board.inLine(tmp2)) {
							if (board.isPiece(tmp2)) {
								if (!board.getPiece(tmp2).equals(group)) {
									// 기록
									Msg.print("말" + tmp2);
									movepoints.add(tmp2);
								}
							} else {
								// 기록
								Msg.print("공백" + tmp2);
								movepoints.add(tmp2);
							}
						}
					}
				}
			}
			break;
		case SANG:
			// 상
			// 상 우 하 좌
			int mp = 0;
			for (int w = 0; w < 4; w++) {
				tmp.set(piece_now_point);
				tmp.move(way[w]);
				if (board.inLine(tmp) && !board.isPiece(tmp)) {
					for (int w2 = 3; w2 < 5; w2++) {
						mp = (w + w2) % 4;
						tmp2.set(tmp);
						tmp2.move(way_diagonal[mp]);
						if (board.inLine(tmp2) && !board.isPiece(tmp2)) {
							tmp2.move(way_diagonal[mp]);
							if (board.inLine(tmp2)) {
								if (board.isPiece(tmp2)) {
									if (!board.getPiece(tmp2).equals(group)) {
										// 기록
										Msg.print("말" + tmp2);
										movepoints.add(tmp2);
									}
								} else {
									// 기록
									Msg.print("공백" + tmp2);
									movepoints.add(tmp2);
								}
							}
						}
					}
				}
			}
			break;
		case SA:
			// 사
			// 궁
			centerflag = true;
			tmp.set(piece_now_point);
			for (int edge = 0; edge < 4; edge++) {
				if (tmp.comper(palace_edge_point[edge]) || tmp.comper(palace_edge_point[edge + 4])) {
					tmp.move(way_diagonal[(edge + 2) % 4]);
					if (board.isPiece(tmp)) {
						if (!board.getPiece(tmp).equals(group)) {
							// 기록
							Msg.print("말" + tmp);
							movepoints.add(tmp);
						}
					} else {
						// 기록
						Msg.print("공백" + tmp);
						movepoints.add(tmp);
					}

					for (int pp2 = 2; pp2 < 4; pp2++) {
						tmp.set(piece_now_point);
						tmp.move(way[(edge + pp2) % 4]);
						if (board.isPiece(tmp)) {
							if (!board.getPiece(tmp).equals(group)) {
								// 기록
								Msg.print("말" + tmp);
								movepoints.add(tmp);
							}
						} else {
							// 기록
							Msg.print("공백" + tmp);
							movepoints.add(tmp);
						}
					}
					centerflag = false;
					break;
				} else if (tmp.comper(palace_point[edge]) || tmp.comper(palace_point[edge + 4])) {
					for (int w2 = 1; w2 < 4; w2++) {
						tmp.set(piece_now_point);
						tmp.move(way[(edge + w2) % 4]);
						if (board.isPiece(tmp)) {
							if (!board.getPiece(tmp).equals(group)) {
								// 기록
								Msg.print("말" + tmp);
								movepoints.add(tmp);
							}
						} else {
							// 기록
							Msg.print("공백" + tmp);
							movepoints.add(tmp);
						}
					}
					centerflag = false;
					break;
				}
			}
			if (centerflag) {
				if (tmp.comper(palace_center_point[0]) || tmp.comper(palace_center_point[1])) {
					for (int pp = 0; pp < 8; pp++) {
						tmp.set(piece_now_point);
						tmp.move(way_all[pp]);
						if (board.isPiece(tmp)) {
							if (!board.getPiece(tmp).equals(group)) {
								// 기록
								Msg.print("말" + tmp);
								movepoints.add(tmp);
							}
						} else {
							// 기록
							Msg.print("공백" + tmp);
							movepoints.add(tmp);
						}
					}
				}
			}
			break;
		case JOL:
			// 졸
			// 좌 우
			int groupflag = 0;
			int[] v;
			if (group.equals(Group.CHOO)) {
				groupflag = 1;
				v = new int[] { 4, 7, 1, 5, 6 };
			} else {
				groupflag = 3;
				v = new int[] { 1, 2, 0, 0, 3 };
			}
			for (int w = 0; w < 3; w++) {
				tmp.set(piece_now_point);
				tmp.move(way[(w + groupflag) % 4]);
				if (board.inLine(tmp)) {
					if (board.isPiece(tmp) && !board.getPiece(tmp).equals(group)) {
						// 기록
						Msg.print("말" + tmp);
						movepoints.add(tmp);
					} else {
						// 기록
						Msg.print("공백" + tmp);
						movepoints.add(tmp);
					}
				}
			}
			// 궁
			tmp.set(piece_now_point);
			if (tmp.comper(palace_edge_point[v[0]]) || tmp.comper(palace_edge_point[v[1]])) {
				tmp2.set(palace_center_point[v[2]]);
				if (board.isPiece(tmp2) && !board.getPiece(tmp2).equals(group)) {
					// 기록
					Msg.print("말" + tmp2);
					movepoints.add(tmp);
				} else {
					// 기록
					Msg.print("공백" + tmp2);
					movepoints.add(tmp);
				}
			} else if (tmp.comper(palace_center_point[v[2]])) {
				for (int pp = 3; pp < 5; pp++) {
					tmp2.set(palace_edge_point[v[pp]]);
					if (board.isPiece(tmp2) && !board.getPiece(tmp2).equals(group)) {
						// 기록
						Msg.print("말" + tmp2);
						movepoints.add(tmp);
					} else {
						// 기록
						Msg.print("공백" + tmp2);
						movepoints.add(tmp);
					}
				}

			}
			break;
		case KING:
			// 왕
			// 궁
			tmp.set(piece_now_point);
			centerflag = true;
			for (int pp = 0; pp < 4; pp++) {
				if (tmp.comper(palace_edge_point[pp]) || tmp.comper(palace_edge_point[pp + 4])) {
					tmp.move(way_diagonal[(2 + pp) % 4]);
					if (board.isPiece(tmp) && !board.getPiece(tmp).equals(group)) {
						// 기록
						Msg.print("말" + tmp);
						movepoints.add(tmp);
					} else {
						// 기록
						Msg.print("공백" + tmp);
						movepoints.add(tmp);
					}
					for (int pp2 = 2; pp2 < 4; pp2++) {
						tmp.set(piece_now_point);
						tmp.move(way[(pp + pp2) % 4]);
						if (board.isPiece(tmp) && !board.getPiece(tmp).equals(group)) {
							// 기록
							Msg.print("말" + tmp);
							movepoints.add(tmp);
						} else {
							// 기록
							Msg.print("공백" + tmp);
							movepoints.add(tmp);
						}
					}
					centerflag = false;
					break;
				} else if (tmp.comper(palace_point[pp]) || tmp.comper(palace_point[pp + 4])) {
					for (int w2 = 1; w2 < 4; w2++) {
						tmp.set(piece_now_point);
						tmp.move(way[(pp + w2) % 4]);
						if (board.isPiece(tmp) && !board.getPiece(tmp).equals(group)) {
							// 기록
							Msg.print("말" + tmp);
							movepoints.add(tmp);
						} else {
							// 기록
							Msg.print("공백" + tmp);
							movepoints.add(tmp);
						}
					}
					centerflag = false;
					break;
				}
			}
			if (centerflag) {
				if (tmp.comper(palace_center_point[0]) || tmp.comper(palace_center_point[1])) {
					for (int pp = 0; pp < 8; pp++) {
						tmp.set(piece_now_point);
						tmp.move(way_all[pp]);
						if (board.isPiece(tmp) && !board.getPiece(tmp).equals(group)) {
							// 기록
							Msg.print("말" + tmp);
							movepoints.add(tmp);
						} else {
							// 기록
							Msg.print("공백" + tmp);
							movepoints.add(tmp);
						}
					}
				}
			}
			break;
		}
	}

	private void chessChack(Point kingpoint) {		
		// 차 포 검사
		tmp.set(kingpoint);
		for (int w = 0; w < 4; w++) {
			while (true) {
				tmp.move(way[w]);
				if (board.inLine(tmp)) {
					if (board.isPiece(tmp)) {
						tmppiece = board.getPiece(tmp);
						if (!tmppiece.equals(group) && tmppiece.equals(PieceSet.CHA)) {
							// 기록
							Msg.print("차" + tmp);
						}
						if (!tmppiece.equals(PieceSet.POO)) {
							while (true) {
								tmp.move(way[w]);
								if (board.inLine(tmp)) {
									if (board.isPiece(tmp)) {
										tmppiece = board.getPiece(tmp);
										if (!tmppiece.equals(group) && tmppiece.equals(PieceSet.POO)) {
											// 기록
											Msg.print("포" + tmp);
										}
									} else {
										// 다음칸
										continue;
									}
								}
								break;
							}
						}
					} else {
						// 다음칸
						continue;
					}
				}
				break;
			}
		}
		// 궁
		tmp.set(kingpoint);
		int pp = (group.equals(Group.CHOO)) ? 0 : 4;
		for (int w = pp; w < pp + 4; w++) {
			if (tmp.comper(palace_edge_point[w])) {
				tmp2.move(way_diagonal[(pp + 2) % 4]);
				if (board.isPiece(tmp2)) {
					tmppiece = board.getPiece(tmp2);
					if (tmppiece.equals(PieceSet.CHA) && !tmppiece.equals(group)) {
						// 기록
						Msg.print("차" + tmp2);
					}
					if (!tmppiece.equals(PieceSet.POO)) {
						tmp2.move(way_diagonal[(pp + 2) % 4]);
						tmppiece = board.getPiece(tmp2);
						if (tmppiece.equals(PieceSet.POO) && !tmppiece.equals(group)) {
							Msg.print("포" + tmp2);
						}
					}
				} else {
					tmp2.move(way_diagonal[(pp + 2) % 4]);
					if (board.isPiece(tmp2)) {
						tmppiece = board.getPiece(tmp2);
						if (tmppiece.equals(PieceSet.CHA) && !tmppiece.equals(group)) {
							// 기록
							Msg.print("차" + tmp2);
						}
					}
				}
				break;
			}
		}
		// 마 상
		for (int w = 0; w < 4; w++) {
			tmp.set(kingpoint);
			tmp.move(way_diagonal[w]);
			if (board.inLine(tmp) && !board.isPiece(tmp)) {
				for (int w2 = 0; w2 < 2; w2++) {
					tmp2.set(tmp);
					tmp2.move(way[(w + w2) % 4]);
					if (board.inLine(tmp2) && board.isPiece(tmp2)) {
						tmppiece = board.getPiece(tmp2);
						if (!tmppiece.equals(group) && tmppiece.equals(PieceSet.MA)) {
							// 기록
							Msg.print("마" + tmp2);
						}
					}
				}
				tmp.move(way_diagonal[w]);
				if (board.inLine(tmp) && board.isPiece(tmp)) {
					for (int w2 = 0; w2 < 2; w2++) {
						tmp2.set(tmp);
						tmp2.move(way[(w + w2) % 4]);
						if (board.inLine(tmp2) && board.isPiece(tmp2)) {
							tmppiece = board.getPiece(tmp2);
							if (!tmppiece.equals(group) && tmppiece.equals(PieceSet.SANG)) {
								// 기록
								Msg.print("상" + tmp2);
							}
						}
					}
				}
			}
		}
		// 졸
		for (int w = 0; w < 3; w++) {
			tmp.set(kingpoint);
			tmp.move(way[w]);
			if (board.isPiece(tmp)) {
				tmppiece = board.getPiece(tmp);
				if (!tmppiece.equals(group) && tmppiece.equals(PieceSet.JOL)) {
					// 기록
					Msg.print("졸" + tmppiece);
				}
			}
		}
		tmp.set(kingpoint);
		if (tmp.comper(palace_center_point[0])) {
			for (int pp1 = 1; pp1 < 3; pp1++) {
				if (board.isPiece(palace_edge_point[pp1])) {
					tmppiece = board.getPiece(palace_edge_point[pp1]);
					if (!tmppiece.equals(group) && tmppiece.equals(PieceSet.JOL)) {
						// 기록
						Msg.print("졸" + tmppiece);
					}
				}
			}
		} else if (tmp.comper(palace_edge_point[0]) || tmp.comper(palace_edge_point[3])) {
			if (board.isPiece(palace_center_point[0])) {
				tmppiece = board.getPiece(palace_center_point[0]);
				if (!tmppiece.equals(group) && tmppiece.equals(PieceSet.JOL)) {
					// 기록
					Msg.print("졸" + tmppiece);
				}
			}
		}
	}
}
